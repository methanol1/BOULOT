package com.natixis.financement.middlesav.united;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.cco.upconnect.commarea.UnitedCommareaDescription;
import com.natixis.financement.middlesav.commun.config.annotations.ExceptionBundle;
import com.natixis.financement.middlesav.commun.exceptions.SavTechnicalException;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaField;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaList;
import com.natixis.financement.middlesav.united.annotation.UnitedCommareaObject;
import com.natixis.financement.middlesav.united.exception.UnitedTechnicalException;

public class UnitedCommareaHandler {

    public static Logger logger = LoggerFactory.getLogger(UnitedCommareaHandler.class);

    @Inject
    @ExceptionBundle
    private ResourceBundle exceptionBundle;

    /**
     * A partir de la description de la commarea passee en paramètre, construit
     * la commarea à destination de UNITED. La commarea est retournée sous forme
     * de String.
     * 
     * @param aDescription
     * @return
     * @throws UnitedTechnicalException
     */
    public String buildCommarea(final UnitedCommareaDescription aDescription) throws UnitedTechnicalException {
        final StringBuffer lBuffer = new StringBuffer();

        final TreeMap<Integer, UnitedCommareaFieldProperties> lListeChamps = new TreeMap<Integer, UnitedCommareaFieldProperties>();

        // 1. Lecture de tous les champs annotés pour les mettre dans le bon
        // ordre
        if (hasSuperclass(aDescription)) {
            // 1.1 Lecture de tous les champs de la superclass de la description
            parseAnnotedFields(aDescription, aDescription.getClass().getSuperclass().getDeclaredFields(), lListeChamps);
            // 1.2 Lecture de tous les champs de la description
            parseAnnotedFields(aDescription, aDescription.getClass().getDeclaredFields(), lListeChamps);
        } else {
            // 1.1 Lecture de tous les champs de la description
            parseAnnotedFields(aDescription, aDescription.getClass().getDeclaredFields(), lListeChamps);
        }

        // 2. Maintenant que les champs sont tous dans l'ordre, on concatène
        // leurs valeurs
        for (UnitedCommareaFieldProperties lFieldProperty : lListeChamps.values()) {
            lBuffer.append(lFieldProperty.getValeur());
        }

        return lBuffer.toString();
    }

    /**
     * Cette méthode détecte si l'objet a une superclass.
     * 
     * @param aDescription
     * @return <code>True</code>, Si l'objet a une superclass
     */
    private boolean hasSuperclass(final Object aDescription) {
        boolean result = false;
        if (aDescription != null && aDescription.getClass() != null && aDescription.getClass().getSuperclass() != null) {
            result = true;
        }
        return result;
    }

    /**
     * Cette méthode parse l'objet {@link UnitedCommareaDescription} pour en
     * extraire les propriétés.
     * 
     * @param aDescription
     *            - Description United
     * @param declaredFields
     *            - Atrributs de la description
     * @param lListeChamps
     *            - Liste parmettant de trier les attributs en fonction de le
     *            leurs positions.
     * @throws UnitedTechnicalException
     */
    @SuppressWarnings("unchecked")
	private void parseAnnotedFields(final UnitedCommareaDescription aDescription, final Field[] declaredFields, final TreeMap<Integer, UnitedCommareaFieldProperties> lListeChamps)
            throws UnitedTechnicalException {

        UnitedCommareaFieldProperties lFieldProperties;

        for (Field lField : declaredFields) {
            try {
                if (lField.isAnnotationPresent(UnitedCommareaField.class)) {
                    final UnitedCommareaField lAnnot = lField.getAnnotation(UnitedCommareaField.class);
                    lField.setAccessible(true);
                    Object lObjectValue;
                    lObjectValue = lField.get(aDescription);
                    String lValue = lObjectValue != null ? lObjectValue.toString() : "";
                    if (lObjectValue == null || lObjectValue instanceof String) {
                        // Les String doivent être complétés par des espaces à
                        // droite.
                        lValue = StringUtils.rightPad(lValue, lAnnot.longueur());
                    } else {
                        // Les valeurs numériques doivent être complétées par
                        // des zéros à gauche.
                        lValue = StringUtils.leftPad(lValue, lAnnot.longueur(), '0');
                    }
                    lFieldProperties = new UnitedCommareaFieldProperties(lAnnot.longueur(), lField.getName(), lValue);
                    lListeChamps.put(lAnnot.position(), lFieldProperties);
                }
                else if(lField.isAnnotationPresent(UnitedCommareaList.class)) {
                	//Nous rencontrons ici un champ de type list
                	//Chaque element de la liste doit etre un objet de type UnitedCommareaDescription
                	//Pour chaque élément de cette liste, il faut parcourir la liste des champs
                	
                	//On recupère tout d'abord l'annotation sur la liste
                	final UnitedCommareaList lAnnot = lField.getAnnotation(UnitedCommareaList.class);
                	int startPosition = lAnnot.position() - 1;// -1 car nous allons y ajouter la position du premier champ de l'element de la liste qui commence à 1
                	
                	lField.setAccessible(true);
                	Object lObjectValue;
                	lObjectValue = lField.get(aDescription);
                	try{
                		List<UnitedCommareaDescription> liste =(List<UnitedCommareaDescription>)lObjectValue;
                		TreeMap<Integer, UnitedCommareaFieldProperties> lListeChampsListe = new TreeMap<Integer, UnitedCommareaFieldProperties>();
                		for(int j = 0 ; j < liste.size();j++){
                			TreeMap<Integer, UnitedCommareaFieldProperties> lLocalSousListeChamps = new TreeMap<Integer, UnitedCommareaFieldProperties>();
                        	parseAnnotedFields(liste.get(j), liste.get(j).getClass().getDeclaredFields(), lLocalSousListeChamps);
                        	for (Iterator<Integer> iterator = lLocalSousListeChamps.keySet().iterator(); iterator
									.hasNext();) {
								Integer position = (Integer) iterator.next();
								lListeChampsListe.put(++startPosition, lLocalSousListeChamps.get(position));
							}
                		}
                		
                		//On doit ensuite mettre à jour la liste des champs principaux
                		for (Iterator<Integer> iterator = lListeChampsListe.keySet().iterator(); iterator
								.hasNext();) {
							Integer position = (Integer) iterator.next();
							lListeChamps.put(position, lListeChampsListe.get(position));
						}
                	}
                	catch(ClassCastException cce){
                		throw new UnitedTechnicalException("Les elements d'une liste doivent être de type UnitedCommareaDescription",cce);
                	}
                	
                }
            } catch (IllegalArgumentException e) {
                final String lMessage = MessageFormat.format(exceptionBundle.getString("united.erreur.lecture.champ"), lField.getName());
                throw new UnitedTechnicalException(lMessage, e);
            } catch (IllegalAccessException e) {
                final String lMessage = MessageFormat.format(exceptionBundle.getString("united.erreur.lecture.champ"), lField.getName());
                throw new UnitedTechnicalException(lMessage, e);
            }
        }
    }

    /**
     * Construit l'objet de retour a partir de la réponse UNITED. Méthode
     * récursive sur les attributs annotés avec UnitedCommareaObject.
     * 
     * @param aCommarea
     * @param aDescClass
     * @return
     * @throws UnitedTechnicalException
     */
    public Object parseCommarea(final String aChaine, final Class<?> aObjetACreer) throws UnitedTechnicalException {

        try {
            // 1. Lecture de tous les champs annot�s de la description pour les
            // mettre dans le bon ordre
            Map<Integer, UnitedCommareaFieldProperties> lListeChamps = new TreeMap<Integer, UnitedCommareaFieldProperties>();
            if (hasSuperclass(aObjetACreer)) {
                lListeChamps = sortAnnotedFields(aObjetACreer.getSuperclass());
            }
            lListeChamps.putAll(sortAnnotedFields(aObjetACreer));

            // 2. Maintenant que les champs sont tous dans l'ordre, on parse la
            // commarea pour alimenter les valeurs
            return buildObjectFromCommArea(aChaine, aObjetACreer, lListeChamps);
        } catch (InstantiationException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.instanciation.commarea"), e);
        } catch (IllegalAccessException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.description.commarea"), e);
        } catch (SecurityException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.parsing.commarea"), e);
        } catch (NoSuchFieldException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.champ.commarea"), e);
        } catch (IllegalArgumentException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.parsing.commarea"), e);
        } catch (ClassNotFoundException e) {
            throw new UnitedTechnicalException(exceptionBundle.getString("united.erreur.class.not.found.commarea"), e);
        }
    }

    /**
     * parse la commarea pour alimenter les valeurs
     * 
     * @param aObjetACreer
     * @return
     */
    private Map<Integer, UnitedCommareaFieldProperties> sortAnnotedFields(final Class<?> aObjetACreer) {
        TreeMap<Integer, UnitedCommareaFieldProperties> lListeChamps = new TreeMap<Integer, UnitedCommareaFieldProperties>();
        UnitedCommareaFieldProperties lFieldProperties;
        for (Field lField : aObjetACreer.getDeclaredFields()) {
            if (lField.isAnnotationPresent(UnitedCommareaField.class)) {
                final UnitedCommareaField lAnnot = lField.getAnnotation(UnitedCommareaField.class);
                lFieldProperties = new UnitedCommareaFieldProperties(lAnnot.longueur(), lField.getName());
                lListeChamps.put(lAnnot.position(), lFieldProperties);
            } else if (lField.isAnnotationPresent(UnitedCommareaObject.class)) {
                final UnitedCommareaObject lAnnot = lField.getAnnotation(UnitedCommareaObject.class);
                lFieldProperties = new UnitedCommareaFieldProperties(lAnnot.longueur(), lField.getName());
                lListeChamps.put(lAnnot.position(), lFieldProperties);
            } else if (lField.isAnnotationPresent(UnitedCommareaList.class)) {
                final UnitedCommareaList lAnnot = lField.getAnnotation(UnitedCommareaList.class);
                lFieldProperties = new UnitedCommareaFieldProperties(lAnnot.longueur(), lField.getName(), lAnnot.nombre());
                lListeChamps.put(lAnnot.position(), lFieldProperties);
            }
        }
        return lListeChamps;
    }

    /**
     * Parse la commarea pour alimenter les valeurs
     * 
     * @param aChaine
     * @param aObjetACreer
     * @param lListeChamps
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchFieldException
     * @throws UnitedTechnicalException
     * @throws ClassNotFoundException
     * @throws SecurityException
     * @throws IllegalArgumentException
     */
    private Object buildObjectFromCommArea(final String aChaine, final Class<?> aObjetACreer, final Map<Integer, UnitedCommareaFieldProperties> lListeChamps) throws IllegalAccessException,
            InstantiationException, NoSuchFieldException, UnitedTechnicalException, IllegalArgumentException, SecurityException, ClassNotFoundException {
        final Object lResultat = aObjetACreer.newInstance();

        // 1 - On détecte si l'object de base à une superclass (Le header)
        Class<?> commareaSuperclass = null;
        if (hasSuperclass(lResultat)) {
            commareaSuperclass = lResultat.getClass().getSuperclass();
        }
        // 2 - Récupération des champs de la superclass
        List<Field> superclassDeclaredFields = new ArrayList<Field>();
        if (commareaSuperclass != null) {
            superclassDeclaredFields = Arrays.asList(commareaSuperclass.getDeclaredFields());
        }

        int curseur = 0;
        for (UnitedCommareaFieldProperties lChamp : lListeChamps.values()) {
            Field lField = null;
            // 3 - Le champs est-il contenu dans la superclass ?
            if (containsFieldsName(superclassDeclaredFields, lChamp.getNom())) {
                lField = commareaSuperclass.getDeclaredField(lChamp.getNom());
            } else {
                lField = lResultat.getClass().getDeclaredField(lChamp.getNom());
            }

            if (lField.isAnnotationPresent(UnitedCommareaField.class)) {
                final String commareaValue = aChaine.substring(curseur, curseur + lChamp.getLongueur()).trim();
                lField.setAccessible(true);
                lField.set(lResultat, commareaValue);
            } else if (lField.isAnnotationPresent(UnitedCommareaObject.class)) {
                final String commareaObject = aChaine.substring(curseur, curseur + lChamp.getLongueur());
                lField.setAccessible(true);
                lField.set(lResultat, parseCommarea(commareaObject, lField.getType()));
            } else if (lField.isAnnotationPresent(UnitedCommareaList.class)) {
                final Integer commareaObjectLenght = lChamp.getNombre() * lChamp.getLongueur();
                final String commareaObject = aChaine.substring(curseur, curseur + commareaObjectLenght);
                lField.setAccessible(true);
                lField.set(lResultat, parseListFromCommarea(lResultat, lField.getName(), commareaObject, lChamp.getNombre(), lChamp.getLongueur()));
            }

            // Attention, en cas de plusieur "lchamp" dans le "lField"
            if (lField.isAnnotationPresent(UnitedCommareaList.class)) {
            	curseur += lChamp.getLongueur() * lChamp.getNombre();
            } else {
            	curseur += lChamp.getLongueur();
            }
        }
        return lResultat;
    }

    /**
     * Cette méthode permet de parse une liste d'objet provenant de la COMMAREA
     * 
     * @param descriptionObject
     *            - L'object répose de base
     * @param descriptionFieldName
     *            - Le nom du champ contenant la liste
     * @param commarea
     *            - La commarea complète contenant la liste d'objet
     * @param numberOfObject
     *            - Le nombre d'objet
     * @param objectLength
     *            - La longueur de chaque objet COMMAREA
     * @return Une liste d'objet
     * @throws UnitedTechnicalException
     * @throws ClassNotFoundException
     * @throws NoSuchFieldException
     * @throws SecurityException
     */
    private List<Object> parseListFromCommarea(final Object descriptionObject, final String descriptionFieldName, final String commarea, int numberOfObject, int objectLength)
            throws UnitedTechnicalException, ClassNotFoundException, SecurityException, NoSuchFieldException {
        // 1 - Récupération de la class de la description UNITED ainsi que sont
        // nom
        Class<?> descriptionClass = descriptionObject.getClass();
        String descriptionClassName = descriptionClass.getName();

        // 2 - Récupération de l'attribut générique afin de déterminer le type
        Class<?> fieldClass = Class.forName(descriptionClassName);
        Field field = fieldClass.getDeclaredField(descriptionFieldName);

        // 3 - Détermination du type générique
        ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
        Type[] types = parameterizedType.getActualTypeArguments();
        Class<?> parameterType = null;
        if (types.length > 0) {
            parameterType = (Class<?>) types[0];
        }

        if (parameterType != null) {
            // 4 - Si le type est renseigné, on découpe la COMMAREA pour former
            // la liste d'object
            String[] commareaObjects = new String[numberOfObject];
            int startSplitIndex = 0;
            for (int i = 0; i < numberOfObject; i++) {
                commareaObjects[i] = commarea.substring(startSplitIndex, startSplitIndex + objectLength);
                startSplitIndex += objectLength;
            }

            // 5 - On parse chaque chaine pour la convertir en object java
            List<Object> resultList = new ArrayList<Object>();
            for (String commareaObject : commareaObjects) {
                resultList.add(parseCommarea(commareaObject, parameterType));
            }
            return resultList;
        } else {
            logger.error("parameterType nul ; impossible de découper la commarea pour découper la liste d'objets.");
            throw new SavTechnicalException("Problème lors de l'analyse de la liste incluse dans la commarea.");
        }
    }

    /**
     * Cette méthode détermine si le nom d'un champ appartient à la liste
     * fournie
     * 
     * @param fields
     *            - Liste de champs
     * @param fieldName
     *            - Nom du champ
     * @return <code>true</code>, si le champs appartient à la liste
     */
    private boolean containsFieldsName(final List<Field> fields, final String fieldName) {
        boolean result = false;
        if (fieldName != null && fields != null) {
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }
}

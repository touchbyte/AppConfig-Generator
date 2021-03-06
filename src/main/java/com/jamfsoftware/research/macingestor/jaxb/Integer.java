//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.03.17 at 09:04:29 AM CDT 
//


package com.jamfsoftware.research.macingestor.jaxb;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.jamfsoftware.research.macingestor.MACDataType;
import com.jamfsoftware.research.macingestor.jaxb.Options.Option;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="defaultValue" type="{}integerValueType" minOccurs="0"/>
 *         &lt;element name="constraint" type="{}integerConstraintType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="keyName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "defaultValue",
    "constraint"
})
@XmlRootElement(name = "integer")
public class Integer implements MACDataType {

    protected IntegerValueType defaultValue;
    protected IntegerConstraintType constraint;
    @XmlAttribute(name = "keyName", required = true)
    protected java.lang.String keyName;

    /**
     * Gets the value of the defaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerValueType }
     *     
     */
    public IntegerValueType getDefaultValue() {
        return defaultValue;
    }

    /**
     * Sets the value of the defaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerValueType }
     *     
     */
    public void setDefaultValue(IntegerValueType value) {
        this.defaultValue = value;
    }

    /**
     * Gets the value of the constraint property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerConstraintType }
     *     
     */
    public IntegerConstraintType getConstraint() {
        return constraint;
    }

    /**
     * Sets the value of the constraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerConstraintType }
     *     
     */
    public void setConstraint(IntegerConstraintType value) {
        this.constraint = value;
    }

    /**
     * Gets the value of the keyName property.
     * 
     * @return
     *     possible object is
     *     {@link java.lang.String }
     *     
     */
    public java.lang.String getKeyName() {
        return keyName;
    }

    /**
     * Sets the value of the keyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link java.lang.String }
     *     
     */
    public void setKeyName(java.lang.String value) {
        this.keyName = value;
    }

	@Override
	public java.lang.String getValidation() {
		java.lang.String attributes = "data-parsley-type=\"integer\" ";
		
		if(constraint != null && constraint.isNullable() != null && !constraint.isNullable()){
    		attributes += "data-parsley-required=\"\" ";
    	}
		
		if(constraint != null && constraint.getMin() != null){
			attributes += "data-parsley-min=\"" + constraint.getMin() + "\" ";
		}
		
		if(constraint != null && constraint.getMax() != null){
			attributes += "data-parsley-max=\"" + constraint.getMax() + "\" ";
		}

		attributes += "data-parsley-validate-if-empty ";
		
		return attributes;
	}

	@Override
	public List<java.lang.String> getDefaultValueList() {
		List<java.lang.String> values = new ArrayList<java.lang.String>();
		if (defaultValue != null && defaultValue.getValue() != null) {
			values.add(defaultValue.getValue().toString());
		} else {
			values.add("");
		}
		return values;
	}

	@Override
	public boolean isUserOrDeviceVariable() {
		return false;
	}

	@Override
	public java.lang.String getDefaultPresentationType() {
		if(constraint != null && constraint.values != null) {
			return "select";
		}
		
		return "input";
	}

	@Override
	public Options getOptions() {
		try {
			Options options = new Options();
			for(java.lang.Integer f : constraint.getValues().value){
				Option o = new Option();
				o.setValue(f.toString());
				o.setSelected(false);
				
				// set the language for display
				List<Language> lang = new ArrayList<Language>();
				Language l = new Language();
				l.setValue(f.toString());
				l.setValueAttribute("en-US");
				lang.add(l);
				o.language = lang;
				
				options.option.add(o);
			}
			return options;
			
		} catch (NullPointerException e){
			return new Options();
		}
	}

	@Override
	public Object getPlistObject(java.lang.String[] submissions) {
		try{
			return java.lang.Integer.parseInt(submissions[0]);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}

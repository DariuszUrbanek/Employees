//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.07.11 at 05:19:51 PM BST 
//


package com.example.du.generated.xsd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="employees"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="employee" type="{}employeeType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="departments"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="department" type="{}departmentType" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "employees",
    "departments"
})
@XmlRootElement(name = "company")
public class Company {

    @XmlElement(required = true)
    protected Company.Employees employees;
    @XmlElement(required = true)
    protected Company.Departments departments;

    /**
     * Gets the value of the employees property.
     * 
     * @return
     *     possible object is
     *     {@link Company.Employees }
     *     
     */
    public Company.Employees getEmployees() {
        return employees;
    }

    /**
     * Sets the value of the employees property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company.Employees }
     *     
     */
    public void setEmployees(Company.Employees value) {
        this.employees = value;
    }

    /**
     * Gets the value of the departments property.
     * 
     * @return
     *     possible object is
     *     {@link Company.Departments }
     *     
     */
    public Company.Departments getDepartments() {
        return departments;
    }

    /**
     * Sets the value of the departments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Company.Departments }
     *     
     */
    public void setDepartments(Company.Departments value) {
        this.departments = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="department" type="{}departmentType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "department"
    })
    public static class Departments {

        @XmlElement(required = true)
        protected List<DepartmentType> department;

        /**
         * Gets the value of the department property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the department property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDepartment().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link DepartmentType }
         * 
         * 
         */
        public List<DepartmentType> getDepartment() {
            if (department == null) {
                department = new ArrayList<DepartmentType>();
            }
            return this.department;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="employee" type="{}employeeType" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "employee"
    })
    public static class Employees {

        @XmlElement(required = true)
        protected List<EmployeeType> employee;

        /**
         * Gets the value of the employee property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the employee property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEmployee().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link EmployeeType }
         * 
         * 
         */
        public List<EmployeeType> getEmployee() {
            if (employee == null) {
                employee = new ArrayList<EmployeeType>();
            }
            return this.employee;
        }

    }

}

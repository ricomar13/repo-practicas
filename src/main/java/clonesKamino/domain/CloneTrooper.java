package clonesKamino.domain;
//Esta clase seria como el DTO con los atributos de entrada, con getters y setters

import jakarta.persistence.*;

@Entity //Esto es para que la dependencia JPA lo reconozca como entidad
@Table(name = "clones republica") //nombre de la tabla para mapear en la base de datos
public class CloneTrooper {
//atributos privados /* Attributes section for the DTO */

    /*JPA pide que generes clave primaria para nuestra Entidad con @Id y generar
    los atributos con @GenerateValue
     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /**
     * Atributo del identificador del clon y nombre
     */
    private String ctNumber;
    private String name;
    /**
     * atributo del rango militar
     */
    private String rank;
    /**
     * Atributo de su estado actual
     */
    private String combatStatus;
    /**
     * Atributo del Jedi a cargo
     */
    private String jediCommander;
    /**
     * Atributo con information adicional
     */
    private String additionalInfo;

    //Constructor para poblar los atributos, es decir asignar valores
    public CloneTrooper(
        String ctNumber,
        String name,
        String rank,
        String combatStatus,
        String jediCommander,
        String additionalInfo) {

        this.ctNumber = ctNumber;
        this.name = name;
        this.rank = rank;
        this.combatStatus = combatStatus;
        this.jediCommander = jediCommander;
        this.additionalInfo = additionalInfo;
    }

    /**
     * Get del identificador del clon
     */
    public String getCtNumber() {
        return ctNumber;
    }
    /**
     * Set del identificador del clon
     */
    public void setCtNumber(String ctNumber) {
        this.ctNumber = ctNumber;
    }
    /**
     * Get del nombre
     */
    public String getName() {
        return name;
    }
    /**
     * Set del nombre
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Get del rango militar
     */
    public String getRank() {
        return rank;
    }
    /**
     * Set del rango militar
     */
    public void setRank(String rank) {
        this.rank = rank;
    }
    /**
     * Get de su estado actual
     */
    public String getCombatStatus() {
        return combatStatus;
    }
    /**
     * Set de su estado actual
     */
    public void setCombatStatus(String combatStatus) {
        this.combatStatus = combatStatus;
    }
    /**
     * Get del Jedi a cargo
     */
    public String getJediCommander() {
        return jediCommander;
    }
    /**
     * Set del Jedi a cargo
     */
    public void setJediCommander(String jediCommander) {
        this.jediCommander = jediCommander;
    }
    /**
     * Get con information adicional
     */
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    /**
     * Set con information adicional
     */
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    @Override
    public String toString() {
        return "CloneTrooper{" +
                "ctNumber='" + ctNumber + '\'' +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                ", combatStatus='" + combatStatus + '\'' +
                ", jediCommander='" + jediCommander + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}

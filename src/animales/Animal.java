/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

public abstract class Animal {

    protected String codigo;
    private LocalDate fechaNacimiento;
    private char sexo;
    private double peso;

    /**
     * Constructor de la clase Animal.
     * Crea un animal a partir de su código, fecha de nacimiento, sexo y peso.
     *
     * @param codigo código identificativo del animal. Debe estar formado por 5
     * caracteres alfanuméricos en minúscula.
     * @param fechaNacimiento fecha de nacimiento del animal en formato ISO
     * (yyyy-MM-dd).
     * @param sexo sexo del animal. Debe ser 'M' para hembra o 'H' para macho.
     * @param peso peso del animal en kilogramos. Debe ser mayor que 0.
     * @throws IllegalArgumentException si el código no tiene un formato válido,
     * si la fecha no es válida, si el sexo no es correcto o si el peso no es
     * mayor que 0.
     */
    public Animal(String codigo, String fechaNacimiento, char sexo, double peso) {

        LocalDate fecha;

        if (!codigo.matches("[0-9a-z]{5}") || (sexo != 'M' && sexo != 'H') || (peso <= 0)) {
            throw new IllegalArgumentException();
        } else {

            try {
                fecha = LocalDate.parse(fechaNacimiento);
            } catch (DateTimeParseException ex) {
                throw new IllegalArgumentException();
            }
            this.codigo = codigo;
            this.fechaNacimiento = fecha;
            this.sexo = sexo;
            this.peso = peso;
        }
    }

    /**
     * Devuelve el código identificativo del animal.
     *
     * @return código del animal
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código identificativo del animal.
     *
     * @param codigo nuevo código del animal
     * @throws IllegalArgumentException si el código no tiene un formato válido
     */
    public void setCodigo(String codigo) {
        if (!codigo.matches("[0-9a-z]{5}")) {
            throw new IllegalArgumentException();
        } else {
            this.codigo = codigo;
        }
    }

    /**
     * Devuelve la fecha de nacimiento del animal.
     *
     * @return fecha de nacimiento del animal
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del animal.
     *
     * @param fechaNacimiento fecha de nacimiento del animal en formato yyyy-MM-dd
     * @throws IllegalArgumentException si la fecha no es válida
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento);
        } catch (DateTimeParseException ex) {
            throw new IllegalArgumentException();
        }

        this.fechaNacimiento = fecha;
    }

    /**
     * Devuelve el sexo del animal.
     *
     * @return sexo del animal
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     *
     * @param sexo sexo del animal
     * @throws IllegalArgumentException si el sexo no es válido
     */
    public void setSexo(char sexo) {
        if ((sexo != 'M' && sexo != 'H')) {
            throw new IllegalArgumentException();
        } else {
            this.sexo = sexo;
        }
    }

    /**
     * Devuelve el peso del animal.
     *
     * @return peso del animal
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Establece el peso del animal.
     *
     * @param peso nuevo peso del animal
     * @throws IllegalArgumentException si el peso no es mayor que 0
     */
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.peso = peso;
        }
    }

    /**
     * Calcula el código hash del objeto.
     *
     * @return valor hash del animal
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.codigo);
        hash = 19 * hash + Objects.hashCode(this.fechaNacimiento);
        hash = 19 * hash + this.sexo;
        hash = 19 * hash + (int) (Double.doubleToLongBits(this.peso) ^ (Double.doubleToLongBits(this.peso) >>> 32));
        return hash;
    }

    /**
     * Compara este animal con otro objeto.
     *
     * @param obj objeto con el que se compara
     * @return true si ambos objetos son iguales; false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (this.sexo != other.sexo) {
            return false;
        }
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en texto del animal.
     *
     * @return cadena con los datos del animal
     */
    @Override
    public String toString() {
        return "Animal{" + "codigo=" + codigo + ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", peso=" + peso + '}';
    }

    /**
     * Devuelve el sonido característico del animal.
     *
     * @return sonido del animal
     */
    public abstract String hacerSonido();

    /**
     * Devuelve la reacción del animal cuando está alegre.
     *
     * @return reacción de alegría
     */
    public abstract String alegrarse();

    /**
     * Devuelve la reacción del animal cuando está enfadado.
     *
     * @return reacción de enfado
     */
    public abstract String enfadarse();

    /**
     * Indica qué tipo de animal es.
     *
     * @return tipo de animal
     */
    public abstract String queSoy();

}
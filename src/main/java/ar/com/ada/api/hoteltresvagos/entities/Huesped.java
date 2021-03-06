package ar.com.ada.api.hoteltresvagos.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;

import org.hibernate.annotations.NaturalId;

import ar.com.ada.api.hoteltresvagos.excepciones.*;

@Entity
@Table(name = "huesped")
public class Huesped {
    @Id
    @Column(name = "huesped_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int huespedId;
    private String nombre;
    @NaturalId
    private int dni;
    private String domicilio;
    @Column(name = "domicilio_alternativo")
    private String domicilioAlternativo;

    @OneToMany(mappedBy = "huesped", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Reserva> reservas = new ArrayList<>();

    public Huesped(String nombre) {
        this.nombre = nombre;

    }

    public Huesped() {
    }

    public int getHuespedId() {
        return huespedId;
    }

    public void setHuespedId(int huespedId) {
        this.huespedId = huespedId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) throws HuespedDNIException {

        if (dni < 0) {

            throw new HuespedDNIException(this, "ocurrio un error con el DNI");

        }
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "Huesped [dni=" + dni + ", nombre=" + nombre + "]";
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilioAlternativo() {
        return domicilioAlternativo;
    }

    public void setDomicilioAlternativo(String domicilioAlternativo) {
        this.domicilioAlternativo = domicilioAlternativo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Auxiliadora
 */
@Entity
@Table(name = "hijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hijo.findAll", query = "SELECT h FROM Hijo h")
    , @NamedQuery(name = "Hijo.findById", query = "SELECT h FROM Hijo h WHERE h.id = :id")
    , @NamedQuery(name = "Hijo.findByNombre", query = "SELECT h FROM Hijo h WHERE h.nombre = :nombre")
    , @NamedQuery(name = "Hijo.findBySexo", query = "SELECT h FROM Hijo h WHERE h.sexo = :sexo")
    , @NamedQuery(name = "Hijo.findByEdad", query = "SELECT h FROM Hijo h WHERE h.edad = :edad")})
public class Hijo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 1)
    @Column(name = "sexo")
    private String sexo;
    @Size(max = 2147483647)
    @Column(name = "edad")
    private String edad;
    @JoinColumn(name = "id_padre", referencedColumnName = "id")
    @ManyToOne
    private Usuario idPadre;

    public Hijo() {
    }

    public Hijo(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public Usuario getIdPadre() {
        return idPadre;
    }

    public void setIdPadre(Usuario idPadre) {
        this.idPadre = idPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hijo)) {
            return false;
        }
        Hijo other = (Hijo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "agenda.Hijo[ id=" + id + " ]";
    }
    
}

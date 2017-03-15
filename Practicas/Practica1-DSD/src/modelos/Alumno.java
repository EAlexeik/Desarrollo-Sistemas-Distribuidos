package modelos;

public class Alumno implements java.io.Serializable  {
    private String nombre, aPaterno, aMaterno, mail,calle,numero, colonia, delegación, entidad, telefono;
    private int idAlumno;

   
    public Alumno()
    {
        
    }
    
    public Alumno(int idAlumno,String nombre, String aPaterno, String aMaterno, String mail, String calle, String numero, String colonia, String delegación, String entidad, String telefono) {
        this.idAlumno=idAlumno;
        this.nombre = nombre;
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
        this.mail = mail;
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.delegación = delegación;
        this.entidad = entidad;
        this.telefono = telefono;
    }
     public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return aPaterno;
    }

    public void setApellidoPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getApellidoMaterno() {
        return aMaterno;
    }

    public void setApellidoMaterno(String Amaterno) {
        this.aMaterno = Amaterno;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getDelegación() {
        return delegación;
    }

    public void setDelegación(String delegación) {
        this.delegación = delegación;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
    
}

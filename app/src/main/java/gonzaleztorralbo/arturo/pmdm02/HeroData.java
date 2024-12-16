package gonzaleztorralbo.arturo.pmdm02;

public class HeroData {
    private final String imagen;
    private final String nombre;
    private final String descripcion;
    private final String habilidades;

    public HeroData(String imagen, String nombre, String descripcion, String habilidades) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.habilidades = habilidades;
    }

    public String getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getHabilidades() {
        return habilidades;
    }


}

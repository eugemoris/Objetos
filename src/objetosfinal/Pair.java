package objetosfinal;

public class Pair {
//Almacena dos objetos
    private Object nombre;
    private Object valor;

    public Pair(Object n, Object v) {
        nombre = n;
        valor = v;
    }

    public void setValor(Object valor) {
        //modifica el valor del segundo objeto
        this.valor = valor;
    }

    public Object getValor() {
        //obtiene el valor de segundo objeto
        return valor;
    }

    @Override
    public String toString() {
        //permite imprimir la clase Pair
        return "Pair [nombre=" + nombre + ", valor=" + valor + "]";
    }

    public Object getNombre() {
        //obtiene el nombre del primer objeto
        return nombre;
    }

    public void setNombre(Object nombre) {
        //cambia el nombre del primer objeto
        this.nombre = nombre;
    }
}

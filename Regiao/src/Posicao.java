import java.util.Objects;

public class Posicao {

    private float latitude;
    private float longitude;
    private float temperatura;
    private String descricao;

    public Posicao(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posicao posicao = (Posicao) o;
        return Float.compare(posicao.latitude, latitude) == 0 &&
                Float.compare(posicao.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}

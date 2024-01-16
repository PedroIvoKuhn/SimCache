package entities;

public class Conjunto {
    private boolean validade;
    private Integer tag;

    public Conjunto(boolean validade, Integer tag) {
        this.validade = validade;
        this.tag = tag;
    }

    public Conjunto() {
        validade = false;
        tag = 0;
    }

    public boolean isValidade() {
        return validade;
    }

    public void setValidade(boolean validade) {
        this.validade = validade;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (validade ? 1231 : 1237);
        result = prime * result + ((tag == null) ? 0 : tag.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Conjunto other = (Conjunto) obj;
        if (validade != other.validade)
            return false;
        if (tag == null) {
            if (other.tag != null)
                return false;
        } else if (!tag.equals(other.tag))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[" + validade + ", tag=" + tag + "]";
    }
}
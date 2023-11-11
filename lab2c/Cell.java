/* NOME: Jônatas Garcia de Oliveira     TIA: 42181232
 * NOME: Pedro Henrique Araujo Farias   TIA: 32246994
 */

public class Cell {
    private int key;
    private String value;

    public Cell(int argKey, String argValue) {
        this.key = argKey;
        this.value = argValue;
    }

    public int getKey() { return key; }

    public void setKey(int argKey) { this.key = argKey; }

    public String getValue() { return value; }

    public void setValue(String argValue) { this.value = argValue; }

    @Override
    public String toString() { return "Chave: " + key + "| Data: " + value; }
}

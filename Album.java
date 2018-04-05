public class Album {

    private int[] figurinhas;
    private int tamanho;
    private int quantFigurinhas;
    private int quantRepetidas;
   
    public Album(int tamanho) {
    	this.tamanho = tamanho;
        this.figurinhas = new int[tamanho + 1];  // desprezando a posicao 0
        esvaziarAlbum();
    }
   
    public void esvaziarAlbum() {
    	this.quantFigurinhas = 0;
        this.quantRepetidas = 0;
        for(int i = 1; i <= this.tamanho; i++) {
            this.figurinhas[i] = 0;
        }
    }
  
    public void acrescentarFigurinha(int figurinha) {
        this.figurinhas[figurinha] += 1;
        if(this.figurinhas[figurinha] == 1) {
       	    this.quantFigurinhas += 1;
            testarAlbumCompleto();
        } else {
            this.quantRepetidas += 1;
        }
    }
   
    private void testarAlbumCompleto() {
    	if(this.quantFigurinhas == this.tamanho) {
    	    System.out.println("Álbum completo!");
        }
    }
}

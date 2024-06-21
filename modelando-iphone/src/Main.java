import model.Iphone;

public class Main {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();

        iphone.ligar("21999999999");
        iphone.atender();
        iphone.iniciarCorreioVoz();

        iphone.exibirPagina("https://google.com.br");
        iphone.atualizarPagina();
        iphone.adicionarNovaAba();

        iphone.selecionarMusica("Danzig - Mother");
        iphone.tocar();
        iphone.pausar();
    }
}
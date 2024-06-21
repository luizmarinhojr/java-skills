package model;

public class Iphone implements AparelhoTelefonico, NavegadorInternet, ReprodutorMusical{

    @Override
    public void ligar(String numero) {
        System.out.println("Ligando para o número " + numero + " do aparelho telefônico...");
    }

    @Override
    public void atender() {
        System.out.println("Atendendo ligação do aparelho telefônico...");
    }

    @Override
    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz do aparelho telefônico...");

    }

    @Override
    public void exibirPagina(String url) {
        System.out.println("Exibindo página web no navegador de internet...");
    }

    @Override
    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba no navegador de internet...");
    }

    @Override
    public void atualizarPagina() {
        System.out.println("Atualizando página web no navegador de internet...");
    }

    @Override
    public void tocar() {
        System.out.println("Tocando música do reprodutor musical...");
    }

    @Override
    public void pausar() {
        System.out.println("Pausando música do reprodutor musical...");
    }

    @Override
    public void selecionarMusica(String musica) {
        System.out.println("Selecionando música do reprodutor musical...");
    }
}

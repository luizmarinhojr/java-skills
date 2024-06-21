package model;

public class Iphone implements IAparelhoTelefonico, INavegadorInternet, IReprodutorMusical {
    private String numero;
    private String imei;
    private String modelo;
    private double ram;

    public Iphone(String numero, String imei, String modelo, double ram) {
        this.numero = numero;
        this.imei = imei;
        this.modelo = modelo;
        this.ram = ram;
    }

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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getImei() {
        return imei;
    }

    public String getModelo() {
        return modelo;
    }

    public double getRam() {
        return ram;
    }
}

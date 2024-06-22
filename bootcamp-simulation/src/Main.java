import br.com.luizmarinho.desafio.dominio.Bootcamp;
import br.com.luizmarinho.desafio.dominio.Curso;
import br.com.luizmarinho.desafio.dominio.Dev;
import br.com.luizmarinho.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devRonaldo = new Dev();
        devRonaldo.setNome("Ronaldo");
        devRonaldo.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Ronaldo:" + devRonaldo.getConteudosInscritos());
        devRonaldo.progredir();
        devRonaldo.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Ronaldo:" + devRonaldo.getConteudosInscritos());
        System.out.println("Conteúdos Concluídos Ronaldo:" + devRonaldo.getConteudosConcluidos());
        System.out.println("XP:" + devRonaldo.calcularTotalXp());

        System.out.println("-------------");

        Dev devLuiza = new Dev();
        devLuiza.setNome("Luiza");
        devLuiza.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Luiza:" + devLuiza.getConteudosInscritos());
        devLuiza.progredir();
        devLuiza.progredir();
        devLuiza.progredir();
        System.out.println("-");
        System.out.println("Conteúdos Inscritos Luiza:" + devLuiza.getConteudosInscritos());
        System.out.println("Conteúdos Concluidos Luiza:" + devLuiza.getConteudosConcluidos());
        System.out.println("XP:" + devLuiza.calcularTotalXp());

    }

}

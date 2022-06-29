package br.com.acme;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.acme.model.Cliente;
import br.com.acme.model.Drone;
import br.com.acme.model.Entrega;
import br.com.acme.model.EntregaNaoPerecivel;
import br.com.acme.model.EntregaPerecivel;
import br.com.acme.model.Localizacao;

public class Importador {
    public static ArrayList<Localizacao> importarLocalizacoes(String nomeArquivo) throws IOException {
      int codigo;
      String logradouro;
      double latitude, longitude;

      ArrayList<Localizacao> retorno = new ArrayList<>();
      Path path = Paths.get(nomeArquivo + ".csv");
      try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
          String multiuse;
          sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
          sc.nextLine();
          while (sc.hasNext()) {
              codigo = sc.nextInt(); 
              logradouro = sc.next();
              latitude = sc.nextDouble();
              longitude = sc.nextDouble();
              Localizacao temp = new Localizacao(codigo, logradouro, latitude, longitude);
              retorno.add(temp);
          }
      }
      catch (DateTimeParseException e) {
          System.out.println("Erro ao ler data: " + e);
      }
      catch (IOException e1) {
          System.err.format("Erro de E/S: %s%n", e1);
      }
      catch (Exception e2) {
          System.out.println("Erro: " + e2);
          System.out.print("Erro - trace da falha: ");
          e2.printStackTrace();
      }
      return retorno;
    }

    public static ArrayList<Drone> importarDrones(String nomeArquivo) throws IOException {
      
      int identificador, codigoLocalizacao;
      double cargaMaxima, autonomia;
      
      ArrayList<Drone> retorno = new ArrayList<>();
      Path path = Paths.get(nomeArquivo + ".csv");
      try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
          sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
          sc.nextLine();
          while (sc.hasNext()) {
            identificador = sc.nextInt();
            cargaMaxima = sc.nextDouble();
            autonomia = sc.nextDouble();
            codigoLocalizacao = sc.nextInt();
            Drone temp = new Drone(identificador, cargaMaxima, autonomia, codigoLocalizacao);
            retorno.add(temp);
          }
      }
      catch (DateTimeParseException e) {
          System.out.println("Erro ao ler data: " + e);
      }
      catch (IOException e1) {
          System.err.format("Erro de E/S: %s%n", e1);
      }
      catch (Exception e2) {
          System.out.println("Erro: " + e2);
          System.out.print("Erro - trace da falha: ");
          e2.printStackTrace();
      }
      return retorno;
  }

  public static ArrayList<Cliente> importarClientes(String nomeArquivo) throws IOException {
    String nome, email, senha;
    int codigoLocalizacao;

    ArrayList<Cliente> retorno = new ArrayList<>();
    Path path = Paths.get(nomeArquivo + ".csv");
    try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
        sc.useDelimiter("[;\\n]"); // separadores: ; e nova linha
        sc.nextLine();
        while (sc.hasNext()) {
          nome = sc.next();
          email = sc.next();
          senha = sc.next();
          codigoLocalizacao = sc.nextInt();
          Cliente temp = new Cliente(nome, email, senha, codigoLocalizacao);
          retorno.add(temp);
        }
    }
    catch (DateTimeParseException e) {
        System.out.println("Erro ao ler data: " + e);
    }
    catch (IOException e1) {
        System.err.format("Erro de E/S: %s%n", e1);
    }
    catch (Exception e2) {
        System.out.println("Erro: " + e2);
        System.out.print("Erro - trace da falha: ");
        e2.printStackTrace();
    }
    return retorno;
}

public static ArrayList<Entrega> importarEntregas(String nomeArquivo) throws IOException {
  int tipo, numero, codigoLocalizacaoOrigem, codigoLocalizacaoDestin;
  String descricao, emailCliente, validadeOuMaterial;
  LocalDate data;
  double peso;
  Entrega temp;

  ArrayList<Entrega> retorno = new ArrayList<>();
  Path path = Paths.get(nomeArquivo + ".csv");
  try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.defaultCharset()))) {
      sc.useDelimiter("[;\\n]");
      sc.nextLine();
      while (sc.hasNext()) {
          tipo = sc.nextInt();
          numero = sc.nextInt();
          descricao = sc.next();
          data = LocalDate.parse(sc.next());
          peso = sc.nextDouble();
          emailCliente = sc.next();
          codigoLocalizacaoOrigem = sc.nextInt();
          codigoLocalizacaoDestin = sc.nextInt();
          validadeOuMaterial = sc.next();
          if (tipo == 2){
            Entrega temp = new EntregaNaoPerecivel(numero,descricao,data,peso,0,emailCliente,codigoLocalizacaoOrigem,codigoLocalizacaoDestin,validadeOuMaterial);
          }
          else {
            Entrega temp = new EntregaPerecivel(numero,descricao,data,peso,0,emailCliente,codigoLocalizacaoOrigem,codigoLocalizacaoDestin,LocalDate.parse(validadeOuMaterial));
          }
        }
  }
  catch (DateTimeParseException e) {
      System.out.println("Erro ao ler data: " + e);
  }
  catch (IOException e1) {
      System.err.format("Erro de E/S: %s%n", e1);
  }
  catch (Exception e2) {
      System.out.println("Erro: " + e2);
      System.out.print("Erro - trace da falha: ");
      e2.printStackTrace();
  }
  return retorno;
}
}
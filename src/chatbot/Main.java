/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot;

import java.io.*;
import java.util.*;

/**
 *
 * @author jake
 */
public class Main {

    String[] typeBears = {"pardo", "panda", "polar", "malayo", "americano", "asiatico"};
    String[] adjetiveType = {"mostrar", "ver", "visualizar", "curiosidad", "tienen", "estan", "tipos", "tiene", "busco", "veo", "hay", "ofrecerme", "ofrecen"};
    String[] typeAction = {"donde", "comprar", "quiero", "necesito", "compro"};
    String[] typeInterest = {"consigo", "encuentro", "interesa"};
    String[] typeGreeting = {"hola", "buenas", "chatbot", "buenas tardes", "buenas noches", "ola", "buena noche", "buena tarde", "buenos dias", "buen dia"};
    String[] typePayment = {"pago", "dinero", "deposito", "transferencia", "criptomoneda", "transferencias"};

    private String clearSentence;
    private Set<String> resultBears = new HashSet<>();
    private Set<String> resultAdjetiveType = new HashSet<>();
    private Set<String> resultTypeActions = new HashSet<>();
    private Set<String> resultTypeGreeting = new HashSet<>();
    private Set<String> resultTypeInterest = new HashSet<>();
    private Set<String> resultTypePayment = new HashSet<>();
    private Scanner scan = new Scanner(System.in);
    private String userResponse;

    public void executeSentence(String sentence) {

        clearSentence = clearSentence(sentence.toLowerCase());

        checkForWordsWithGreeting(clearSentence, typeBears);
        checkForWordsAdjetiveType(clearSentence, adjetiveType);
        checkForWordsTypeAction(clearSentence, typeAction);
        checkForWordsTypeGreeting(clearSentence, typeGreeting);
        checkForWordsWithInterest(clearSentence, typeInterest);
        checkForWordsWithPayment(clearSentence, typePayment);

        detectUserBehavior();
    }

    public String clearSentence(String words) {

        words = words.replace(",", " ");
        words = words.replace(".", " ");
        words = words.replace("?", " ");

        return words;
    }

    public void checkForWordsWithGreeting(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");

        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultBears.add(word);
                    break;
                }
            }
        }
    }

    public void checkForWordsAdjetiveType(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");
        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultAdjetiveType.add(word);
                    break;
                }
            }
        }
    }

    public void checkForWordsTypeAction(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");

        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultTypeActions.add(word);
                    break;
                }
            }
        }
    }

    public void checkForWordsTypeGreeting(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");
        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultTypeGreeting.add(word);
                    break;
                }
            }
        }
    }

    public void checkForWordsWithInterest(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");
        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultTypeInterest.add(word);
                    break;
                }
            }
        }
    }

    public void checkForWordsWithPayment(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");
        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultTypePayment.add(word);
                    break;
                }
            }
        }
    }

    public void detectUserBehavior() {

        int typeIntention = 0;

        for (String bears : resultBears) {
            typeIntention = 1;
            //System.out.println("Tipos de osos que pregunta: " + bears);
        }

        for (String adjetive : resultAdjetiveType) {
            typeIntention = 2;
            //System.out.println("Tipos de adjetivos: " + adjetive);
        }

        for (String action : resultTypeActions) {
            typeIntention = 3;
            //System.out.println("Tipos de acciones: " + action);
        }

        for (String greeting : resultTypeGreeting) {
            typeIntention = 4;
            //System.out.println("Tipos de saludos: " + greeting);
        }

        for (String greeting : resultTypeInterest) {
            typeIntention = 5;
            //System.out.println("Tipos de saludos: " + greeting);
        }

        for (String greeting : resultTypePayment) {
            typeIntention = 6;
            //System.out.println("Tipos de saludos: " + greeting);
        }

        switch (typeIntention) {
            case 0:
                System.out.println("No entiendo!");
                break;
            case 1:
                break;
            case 2:
                System.out.println("Los osos que tenemos disponibles son los siguientes: ");
                System.out.println("pardo,panda,polar,malayo,americano,asiatico");
                break;
            case 3:
                System.out.println("Que oso de peluche deseas comprar?");
                break;
            case 4:
                System.out.println("Buenas tardes estimado usuario.\nEn que puedo ayudarlo?");
                break;
            case 5:
                System.out.println("Puedes conseguir los osos de peluche por aca");
                break;
            case 6:
                System.out.println("Aceptamos todos los metodos de pago incluso criptomonedas");
                break;
        }
        clearLastValues();
       // waitResponse(); utilizar solamente en consola
    }

    public void clearLastValues() {
        resultBears = new HashSet<>();
        resultAdjetiveType = new HashSet<>();
        resultTypeActions = new HashSet<>();
        resultTypeGreeting = new HashSet<>();
        resultTypeInterest = new HashSet<>();
        resultTypePayment = new HashSet<>();
    }

    public void waitResponse() {
        userResponse = scan.nextLine();

        executeSentence(userResponse);
    }

}

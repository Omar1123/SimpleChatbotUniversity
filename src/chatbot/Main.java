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
    String[] adjetiveType = {"mostrar", "ver", "visualizar", "curiosidad", "tienen", "estan", "tipos", "tiene", "busco", "veo", "hay", "ofrecerme", "ofrecen", "osos", "peluches"};
    String[] typeAction = {"donde", "comprar", "quiero", "necesito", "compro"};
    String[] typeInterest = {"consigo", "encuentro", "interesa"};
    String[] typeGreeting = {"hola", "buenas", "buena", "chatbot", "buenas tardes", "buenas noches", "ola", "buena noche", "buena tarde", "buenos dias", "buen dia"};
    String[] typePayment = {"pago", "dinero", "deposito", "transferencia", "criptomoneda", "transferencias"};
    //Preguntas
    String[] questions = {"cuanto", "cuesta", "que", "valor", "tiene", "a", "precio"};

    private String clearSentence;
    private Set<String> resultBears = new HashSet<>();
    private Set<String> resultAdjetiveType = new HashSet<>();
    private Set<String> resultTypeActions = new HashSet<>();
    private Set<String> resultTypeGreeting = new HashSet<>();
    private Set<String> resultTypeInterest = new HashSet<>();
    private Set<String> resultTypePayment = new HashSet<>();
    private Set<String> resultQuestion = new HashSet<>();
    private Scanner scan = new Scanner(System.in);
    private String userResponse;

    public String executeSentence(String sentence) {

        clearSentence = clearSentence(sentence.toLowerCase());

        checkForWordsWithGreeting(clearSentence, typeBears);
        checkForWordsAdjetiveType(clearSentence, adjetiveType);
        checkForWordsTypeAction(clearSentence, typeAction);
        checkForWordsTypeGreeting(clearSentence, typeGreeting);
        checkForWordsWithInterest(clearSentence, typeInterest);
        checkForWordsWithPayment(clearSentence, typePayment);

        //pregunta
        checkQuestion(clearSentence, questions);

        return detectUserBehavior();
    }

    public String clearSentence(String words) {

        words = words.replace(",", " ");
        words = words.replace(".", " ");
        words = words.replace("?", " ");

        return words;
    }

    public void checkQuestion(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");

        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultQuestion.add(word);
                }
            }
        }
    }

    public void checkForWordsWithGreeting(String sentence, String[] words) {
        String[] wordsInSentence = sentence.split(" ");

        for (String word : wordsInSentence) {
            for (String word2 : words) {
                if (word.equals(word2)) {
                    resultBears.add(word);
                    // break;
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
                    // break;
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
                    //  break;
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
                    // break;
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
                    //break;
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
                    // break;
                }
            }
        }
    }

    public String detectUserBehavior() {
        String response = "";
        int typeIntention = geIntention();

        if (typeIntention != 7) {
            switch (typeIntention) {
                case 0:
                   response= "No entiendo!";
                    break;
                case 1:
                    break;
                case 2:
                   response = "Los osos que tenemos disponibles son los siguientes: pardo,panda,polar,malayo,americano,asiatico";
                    break;
                case 3:
                    response ="Que oso de peluche deseas comprar?";
                    break;
                case 4:
                    response = "Mucho gusto estimado usuario.\nEn que puedo ayudarlo?";
                    break;
                case 5:
                   response = "Puedes conseguir los osos de peluche por aca";
                    break;
                case 6:
                    response = "Aceptamos todos los metodos de pago incluso criptomonedas";
                    break;
            }
        } else {
            System.out.println("pregunta");
        }

        clearLastValues();
        return response;
        //waitResponse();// utilizar solamente en consola
    }

    public void clearLastValues() {
        resultBears = new HashSet<>();
        resultAdjetiveType = new HashSet<>();
        resultTypeActions = new HashSet<>();
        resultTypeGreeting = new HashSet<>();
        resultTypeInterest = new HashSet<>();
        resultTypePayment = new HashSet<>();
        resultQuestion = new HashSet<>();
    }

    public int geIntention() {
        int intention = 0;
        int max = 0;
        List<Integer> t = new ArrayList<Integer>();
        t.add(resultBears.size());
        t.add(resultAdjetiveType.size());
        t.add(resultTypeActions.size());
        t.add(resultTypeGreeting.size());
        t.add(resultTypeInterest.size());
        t.add(resultTypePayment.size());
        t.add(resultQuestion.size());

        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) > max) {
                max = i;
            }
        }

        switch (max) {
            case 0:
                intention = 1;
                break;
            case 1:
                intention = 2;
                break;
            case 2:
                intention = 3;
                break;
            case 3:
                intention = 4;
                break;
            case 4:
                intention = 5;
                break;
            case 5:
                intention = 6;
                break;
            case 6:
                intention = 7;
                break;
        }

        return intention;
    }

    public void waitResponse() {
        userResponse = scan.nextLine();

        executeSentence(userResponse);
    }

}

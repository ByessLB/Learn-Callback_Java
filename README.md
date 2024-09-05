# Les Callbacks

## Introduction

### Qu'est ce qu'un Callback ?

Un Callback est une fonction qui est passé comme argument à une autre fonction et qui est appelée lorsque cette fonction termine son exécution. En Java, les callbacks sont souvent utilisés pour gérer des événements asynchrones, comme les événements de l'interface utilisateur, les appels réseau, ou les tâches de fond.

### Pourquoi utiliser des Callbacks ?

Les callbacks permettent de structurer le code de manière asynchrone, ce qui est particulièrement utile pour les applications qui doivent rester réactives tout en effectuant des tâches longues ou bloquantes.

## Implémentation des Callbacks en Java

### Utilisation des Interfaces

En Java, les callbacks sont généralement implémentés à l'aide d'interfaces. Une interface de callback définit une ou plusieurs méthodes que la classe appelante doit implémenter.

### Exemple Simple

#### Définition de l'Interface de Callback
```java
public interface Callback {
    void onSuccess(String result);
    void onFailure(String error);
}
```

#### Classe Utilisant le Callback
```java
public class Task {
    public void execute(Callback callback) {
        // Simuler une tâche asynchrone
        new Thread(() -> {
            try {
                // Simuler un délai
                Thread.sleep(2000);
                // Appeler le callback de succès
                callback.onSuccess("Tâche terminée avec succès.");
            } catch (InterruptedException e) {
                // Appeler le callback d'échec
                callback.onFailure("Erreur lors de l'exécution de la tâche.");
            }
        }).start();
    }
}
```

#### Utilisation du Callback
```java
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        task.execute(new Callback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Succès : " + result);
            }

            @Override
            public void onFailure(String error) {
                System.out.println("Échec : " + error);
            }
        });
    }
}
```

### Utilisation des Lambdas

Depuis Java 8, les expressions lambda peuvent être utilisées pour implémenter des interfaces fonctionnelles de manière plus concise.

#### Exemple avec Lambda
```java
public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        task.execute((result) -> {
            System.out.println("Succès : " + result);
        },(error) -> {
            System.out.println("Échec : " + error);
        });
    }
}
```

### Interfaces Fonctionnelles

Les interfaces fonctionnelles sont des interfaces qui contiennent une seule méthode abstraite. Elles sont souvent utilisées pour les callbacks.

#### Exemple avec Interface Fonctionnelle
```java
@FunctionalInterface
public interface SimpleCallback {
    void onComplete(String result);
}

public class Task {
    public void execute(SimpleCallback callback) {
        // Simuler une tâche asynchrone
        new Thread(() -> {
            try {
                // Simuler un délai
                Thread.sleep(2000);
                // Appeler le callback
                callback.onComplete("Tâche terminée avec Succès !");
            } catch (InterruptedException e) {
                // Appeler le callback avec un message d'erreur
                callback.onComplete("Erreur lors de l'exécution de la tâche.");
            }
        }).start();
    }
}

public class Main {
    public static void main(String[] args) {
        Task task = new Task();
        task.execute((result) -> {
            System.out.println("Succès : " + result);
        });
    }
}
```

## Utilisation des Callbacks dans les Interfaces Utilisateur

### Exemple avec Swing

Les callbacks sont couramment utilisés dans les interfaces utilisateur pour gérer les événements, comme les clics de boutons.
```java
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame fram = new JFrame("Callback Example");
        JButton button = new JButton("Cliquez-moi");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Appeler le callback
                System.out.println("Bouton cliqué !");
            }
        });

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

### Utilisation des Lambdas avec Swing
```java
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Callback Example");
        JButton button = new JButton("Cliquez-moi");

        button.addActionListener(e -> System.out.println("Bouton cliqué !"));

        frame.add(button);
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

## Conclusion

Les callbacks en Java sont un moyen puissant de gérer les événements asynchrones et de structurer le code de manière réactive. En utilisant des interfaces, des expressions lambda et des interfaces fonctionnelles, vous pouvez implémenter des callbacks de manière concise et efficace. Les callbacks sont particulièrement utiles dans les applications qui doivent rester réactives tout en effectuant des tâches longues ou bloquantes.
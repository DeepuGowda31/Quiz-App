package com.quiz.deepak;

import java.util.*;

public class QuizApp {
	private Scanner sc = new Scanner(System.in);
	private int correctAnsCount = 0;
	private int wrongAnsCount = 0;
	private long totalTimeTaken = 0;
	private String username;

	public void start() {
		System.out.println("Welcome to the Quiz App!");
		System.out.print("Enter your username: ");
		username = sc.nextLine();

		while (true) {
			System.out.println("\nSelect a category:");
			System.out.println("1. Java");
			System.out.println("2. Science");
			System.out.println("3. History");
			int categoryChoice = sc.nextInt();
			sc.nextLine(); // consume newline

			System.out.println("\nSelect a difficulty level:");
			System.out.println("1. Easy");
			System.out.println("2. Medium");
			System.out.println("3. Hard");
			int difficultyChoice = sc.nextInt();
			sc.nextLine(); // consume newline

			List<Questions> selectedQuestions = getQuestions(categoryChoice, difficultyChoice);
			Collections.shuffle(selectedQuestions); // randomize question order

			for (Questions question : selectedQuestions) {
				long startTime = System.currentTimeMillis();
				System.out.println(question.getQuestion());
				System.out.println(question.getOption1());
				System.out.println(question.getOption2());
				System.out.println(question.getOption3());
				System.out.println(question.getOption4());

				System.out.print("Enter Your Answer: ");
				char ans = sc.next().charAt(0);
				long endTime = System.currentTimeMillis();
				totalTimeTaken += (endTime - startTime) / 1000; // time in seconds

				if (Character.toUpperCase(ans) == Character.toUpperCase(question.getAnswer())) {
					System.out.println("Correct");
					correctAnsCount++;
				} else {
					System.out.println("Wrong");
					wrongAnsCount++;
				}
			}

			showResults();
			updateLeaderboard();

			System.out.print("Do you want to play another quiz? (yes/no): ");
			if (!sc.next().equalsIgnoreCase("yes")) {
				break;
			}
			resetQuiz();
		}
		sc.close();
	}

	private List<Questions> getQuestions(int categoryChoice, int difficultyChoice) {
		List<Questions> questions = new ArrayList<>();
		if (categoryChoice == 1) { // Java
			if (difficultyChoice == 1) { // Easy
				questions.add(new Questions("Which statement is true about Java?",
						"A. Java is a sequence-dependent programming language",
						"B. Java is a code-dependent programming language",
						"C. Java is a platform-dependent programming language",
						"D. Java is a platform-independent programming language", 'D', "easy"));
				questions.add(new Questions("What is the extension of Java code files?", "A. .txt", "B. .pdf",
						"C. .sql", "D. .java", 'D', "easy"));
				questions.add(new Questions("Who invented Java Programming?", "A. Guido van Rossum", "B. James Gosling",
						"C. Dennis Ritchie", "D. Bjarne Stroustrup", 'B', "easy"));
			} else if (difficultyChoice == 2) { // Medium
				questions.add(new Questions("Which company initially developed Java?", "A. Sun Microsystems", "B. IBM",
						"C. Microsoft", "D. Apple", 'A', "medium"));
				questions.add(new Questions("Which method is the entry point for a Java program?", "A. start()",
						"B. main()", "C. init()", "D. run()", 'B', "medium"));
				questions.add(new Questions("What is the default value of a local variable?", "A. 0", "B. null",
						"C. Undefined", "D. Depends on the data type", 'C', "medium"));
			} else if (difficultyChoice == 3) { // Hard
				questions.add(new Questions("Which of these are not a type of exception in Java?", "A. IOException",
						"B. SQLException", "C. MemoryException", "D. ArrayIndexOutOfBoundsException", 'C', "hard"));
				questions.add(new Questions("What is the use of the 'transient' keyword?", "A. To serialize a field",
						"B. To prevent serialization of a field", "C. To make a field constant",
						"D. To define a synchronized block", 'B', "hard"));
				questions.add(new Questions("Which of the following is true about a static method?",
						"A. It cannot be called from a static context", "B. It can access instance variables",
						"C. It can access static variables directly", "D. It is bound to the instance of the class",
						'C', "hard"));
			}
		} else if (categoryChoice == 2) { // Science
			if (difficultyChoice == 1) { // Easy
				questions.add(new Questions("What planet is known as the Red Planet?", "A. Earth", "B. Mars",
						"C. Jupiter", "D. Saturn", 'B', "easy"));
				questions.add(new Questions("What is the chemical symbol for water?", "A. H2", "B. O2", "C. H2O",
						"D. CO2", 'C', "easy"));
				questions.add(new Questions("How many states of matter are there?", "A. 2", "B. 3", "C. 4", "D. 5", 'B',
						"easy"));
			} else if (difficultyChoice == 2) { // Medium
				questions.add(new Questions("What is the speed of light?", "A. 300,000 km/s", "B. 150,000 km/s",
						"C. 450,000 km/s", "D. 600,000 km/s", 'A', "medium"));
				questions.add(new Questions("What is the powerhouse of the cell?", "A. Nucleus", "B. Ribosome",
						"C. Mitochondria", "D. Chloroplast", 'C', "medium"));
				questions.add(new Questions("What gas do plants absorb from the atmosphere?", "A. Oxygen",
						"B. Nitrogen", "C. Hydrogen", "D. Carbon Dioxide", 'D', "medium"));
			} else if (difficultyChoice == 3) { // Hard
				questions.add(new Questions("What is the most abundant gas in Earth's atmosphere?", "A. Oxygen",
						"B. Hydrogen", "C. Nitrogen", "D. Carbon Dioxide", 'C', "hard"));
				questions.add(new Questions("What particle is responsible for electricity?", "A. Proton", "B. Neutron",
						"C. Electron", "D. Photon", 'C', "hard"));
				questions.add(new Questions("Which element has the highest melting point?", "A. Iron", "B. Tungsten",
						"C. Gold", "D. Silver", 'B', "hard"));
			}
		} else if (categoryChoice == 3) { // History
			if (difficultyChoice == 1) { // Easy
				questions.add(new Questions("Who was the first President of the United States?", "A. George Washington",
						"B. Thomas Jefferson", "C. Abraham Lincoln", "D. John Adams", 'A', "easy"));
				questions.add(new Questions("In what year did World War II end?", "A. 1942", "B. 1943", "C. 1944",
						"D. 1945", 'D', "easy"));
				questions.add(new Questions("Who discovered America?", "A. Christopher Columbus",
						"B. Ferdinand Magellan", "C. Marco Polo", "D. Leif Erikson", 'A', "easy"));
			} else if (difficultyChoice == 2) { // Medium
				questions.add(new Questions("What was the main cause of the American Civil War?", "A. Slavery",
						"B. Taxation", "C. Territory disputes", "D. Trade", 'A', "medium"));
				questions
						.add(new Questions("Which empire was known as the 'Land of the Rising Sun'?", "A. Roman Empire",
								"B. Ottoman Empire", "C. Japanese Empire", "D. British Empire", 'C', "medium"));
				questions.add(new Questions("Who was the first emperor of China?", "A. Liu Bang", "B. Kublai Khan",
						"C. Qin Shi Huang", "D. Sun Yat-sen", 'C', "medium"));
			} else if (difficultyChoice == 3) { // Hard
				questions.add(new Questions("What treaty ended World War I?", "A. Treaty of Versailles",
						"B. Treaty of Tordesillas", "C. Treaty of Paris", "D. Treaty of Ghent", 'A', "hard"));
				questions.add(new Questions("Who was the longest-reigning British monarch?", "A. Queen Victoria",
						"B. Queen Elizabeth I", "C. King George III", "D. Queen Elizabeth II", 'D', "hard"));
				questions.add(new Questions("Which war was fought between the houses of Lancaster and York?",
						"A. Hundred Years' War", "B. War of the Roses", "C. English Civil War", "D. The Crusades", 'B',
						"hard"));
			}
		}
		return questions;
	}

	private void showResults() {
		System.out.println();
		System.out.println("--------Result---------");
		System.out.println("Total Questions: " + (correctAnsCount + wrongAnsCount));
		System.out.println("Correct Answered Questions: " + correctAnsCount);
		System.out.println("Wrong Answered Questions: " + wrongAnsCount);
		int percentage = (100 * correctAnsCount) / (correctAnsCount + wrongAnsCount);
		System.out.println("Percentage: " + percentage + "%");
		if (percentage > 95) {
			System.out.println("Performance: Very Good");
		} else if (percentage < 35) {
			System.out.println("Performance: Very Low");
		} else {
			System.out.println("Performance: Medium");
		}
		System.out.println("Total Time Taken: " + totalTimeTaken + " seconds");
	}

	private void updateLeaderboard() {
		System.out.println("Updating leaderboard...");
		System.out.println(username + " - " + correctAnsCount + " correct answers in " + totalTimeTaken + " seconds");
	}

	private void resetQuiz() {
		correctAnsCount = 0;
		wrongAnsCount = 0;
		totalTimeTaken = 0;
	}
}

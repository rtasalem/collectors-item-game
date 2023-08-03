package com.rtasalem.collectorsItem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame window;
	Container container;
	JPanel titlePanel, authorPanel, startContinueButtonPanel, storyTextPanel, choiceButtonPanel, inventoryPanel;
	JLabel titleLabel, authorLabel, inventoryLabel, inventoryLabelCount;
	JButton startContinueButton, choice1, choice2;
	JTextArea storyTextArea;
	Font titleFont = new Font("Times New Roman", Font.ITALIC, 100);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
	String position;
	int inventory;

	TitleScreenHandler titleScreenHandler = new TitleScreenHandler();
	GameIntroHandler gameIntroHandler = new GameIntroHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		window = new JFrame();
		window.setSize(1440, 875);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		container = window.getContentPane();

		titlePanel = new JPanel();
		titlePanel.setBounds(10, 100, 1400, 110);
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel(" C O L L E C T O R ' S  I T E M");
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(titleFont);

		authorPanel = new JPanel();
		authorPanel.setBounds(560, 225, 350, 50);
		authorPanel.setBackground(Color.black);
		authorLabel = new JLabel("A game by Rana Salem");
		authorLabel.setForeground(Color.white);
		authorLabel.setFont(normalFont);

		startContinueButtonPanel = new JPanel();
		startContinueButtonPanel.setBounds(630, 500, 200, 100);
		startContinueButtonPanel.setBackground(Color.black);
		startContinueButton = new JButton("START");
		startContinueButton.setForeground(Color.black);
		startContinueButton.setFont(normalFont);
		startContinueButton.setFocusPainted(false);
		startContinueButton.addActionListener(titleScreenHandler);

		titlePanel.add(titleLabel);
		authorPanel.add(authorLabel);
		startContinueButtonPanel.add(startContinueButton);

		container.add(titlePanel);
		container.add(authorPanel);
		container.add(startContinueButtonPanel);

		window.setVisible(true);

	}

	public void gameIntro() {

		titlePanel.setVisible(false);
		authorPanel.setVisible(false);
		startContinueButtonPanel.setVisible(false);

		storyTextPanel = new JPanel();
		storyTextPanel.setBounds(100, 100, 1250, 250);
		storyTextPanel.setBackground(Color.black);
		storyTextArea = new JTextArea("The date is 22nd July 2023. \n\nYou are Detective Sergeant (D.S.) Thomas Doyle. "
				+ "\n\nThe time is 03:45am, you have just arrived home and have gotten into bed. "
				+ "You wanted to sleep right away so no one would notice the lack of sleep you've been getting, D.C. Williamson has already caught on.");
		storyTextArea.setBounds(200, 200, 1250, 250);
		storyTextArea.setBackground(Color.black);
		storyTextArea.setForeground(Color.white);
		storyTextArea.setFont(normalFont);
		storyTextArea.setLineWrap(true);
		storyTextPanel.add(storyTextArea);

		startContinueButtonPanel = new JPanel();
		startContinueButtonPanel.setBounds(630, 500, 200, 100);
		startContinueButtonPanel.setBackground(Color.black);
		startContinueButton.setText("CONTINUE");
		startContinueButton.addActionListener(gameIntroHandler);

		startContinueButtonPanel.add(startContinueButton);

		container.add(storyTextPanel);
		container.add(startContinueButtonPanel);

	}

	public void prologue() {

		position = "prologue";

		storyTextPanel.setVisible(false);
		startContinueButtonPanel.setVisible(false);

		storyTextArea.setText("You're phone begins to ring. "
				+ "\n\nYou ignore the first 2 calls, knowing that it's Sarah. "
				+ "\n\nYou worry that if you answered the phone on the first call, she would later realise you had been awake so late.");
		storyTextArea.setBounds(100, 100, 1250, 250);
		storyTextArea.setBackground(Color.black);
		storyTextArea.setForeground(Color.white);
		storyTextArea.setFont(normalFont);
		storyTextArea.setLineWrap(true);
		storyTextPanel.add(storyTextArea);

		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(575, 475, 300, 100);
		choiceButtonPanel.setBackground(Color.black);

		choice1 = new JButton("Answer the phone");
		choice1.setForeground(Color.black);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);

		choice2 = new JButton("Miss another call");
		choice2.setForeground(Color.black);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);

		container.add(storyTextArea);
		container.add(choiceButtonPanel);

	}

	public void answerPhone() {

		position = "answerPhone";

		choice1.setText(">");
		choice2.setVisible(false);

		storyTextArea.setText("Sarah: Tom, sorry. I know it's late. " + "\nTom: It's fine, what's happened? "
				+ "\nSarah: Three bodies found within a 5 mile radius, all appear to have the same M.O. "
				+ "\nTom: Three? \nYou're confused. That's not quite right. \nTom: I'm on my way.");

	}

	public void missedCall() {

		position = "missedCall";

		choice1.setVisible(false);
		choice2.setText(">");

		storyTextArea.setText("You pick up your phone and call Sarah. "
				+ "\n\nTom: Yeah? \nSarah: Tom, you need to get here now. Will text the address. You won't believe it. "
				+ "\nTom: I'm heading out now.");

	}

	public void chapterOne() {

		position = "chapterOne";

		choice1.setVisible(true);
		choice1.setText("Inspect hair clip");
		choice2.setVisible(true);
		choice2.setText("Inspect lip gloss");

		storyTextArea.setText(
				"You're standing in a wide field. \nForensics are clad in full body suits. \nThey've dividing the scene into grids so they can each inspect a smaller area. "
						+ "\n\nAt your feet you recognise the hair clip and lip gloss. "
						+ "\nYou look around to see where everyone else is before looking back down. "
						+ "\nYour eyes move between the two items hidden in the grass...");

		inventoryPanel = new JPanel();
		inventoryPanel.setBounds(100, 10, 600, 50);
		inventoryPanel.setBackground(Color.black);
		inventoryPanel.setLayout(new GridLayout(1, 2));
		container.add(inventoryPanel);
		inventoryLabel = new JLabel("INVENTORY:");
		inventoryLabel.setFont(normalFont);
		inventoryLabel.setForeground(Color.blue);
		inventoryPanel.add(inventoryLabel);
		inventoryLabelCount = new JLabel();
		inventoryLabelCount.setFont(normalFont);
		inventoryLabelCount.setForeground(Color.blue);
		inventoryPanel.add(inventoryLabelCount);

		inventorySetup();

	}

	public void inventorySetup() {

		inventory = 0;
		inventoryLabelCount.setText("" + inventory);

	}

	public void inspectHairClip() {

		position = "inspectHairClip";

		choice1.setVisible(true);
		choice1.setText(">>");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Sarah: Tom? Come take a look at this. \nYou walk over to where Sarah is standing, the body is not too far behind her. "
						+ "\nSarah: They can't be certain till the autopsy, but it looks like she was strangled."
						+ "\nYou only nod. Sarah looks at you, stares into the side of your head. \nYou pretend to look around the wider area. "
						+ "\nSarah: We should make our way to the next location. I think Donald could use our help. "
						+ "\nTom: I'll drive.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void inspectLipGloss() {

		position = "inspectLipGloss";

		choice1.setVisible(false);
		choice2.setVisible(true);
		choice2.setText(">>");

		storyTextArea.setText("Sarah: Donald says the girl was likely strangled as well from the marks on her neck. "
				+ "\nYou don't say anything, you only look at the road as you drive to the next crime scene."
				+ "\nSarah: How does one man do this in a matter of hours? \nTom: How do you know it's a man? "
				+ "\nSarah: Going off statistics I suppose."
				+ "\nYou shrug in agreement. The rest of the drive continues in silence.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void chapterTwo() {

		position = "chapterTwo";

		choice1.setVisible(true);
		choice1.setText("Inspect necklace");
		choice2.setVisible(true);
		choice2.setText("Inspect glasses");

		storyTextArea.setText(
				"Donald and Sarah are speaking beside you. You start walking down the alleyway where the body was "
				+ "\nfound. At the end of the alleyway, something small shines. You make your way. "
						+ "\nThere's a crunch beneath your boot. You look down and it's a pair of glasses. You look behind you to "
						+ "\nsee if someone saw. You approach the shining object and notice it's a necklace. It's one she wore everyday...");

	}

	public void inspectNecklace() {

		position = "inspectNecklace";

		choice1.setText(">>>");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Sarah: Find anything? \n\nYou're fist, which is tucked inside your coat pocket, clenches tightly around the necklace. The chain is "
				+ "\ncold in your hand. \n\nTom: Broken glasses, few metres back. \nSarah calls one of the CSIs to take a look. You walk back to where you left Donald.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void inspectGlasses() {

		position = "inspectGlasses";

		choice1.setVisible(false);
		choice2.setVisible(true);
		choice2.setText(">>>");

		storyTextArea.setText(
				"Sarah: Tom, is everything alright? \nYou didn't get to inspect the necklace. Sarah saw the glasses as soon as she stopped to stand beside you. "
						+ "\nTom: Broken glasses, might be the girl's?"
						+ "\nSarah looks down, quickly turns back to the team of CSIs and calls one over to collect the glasses in an evidence bag."
						+ "\nYou both walk back to where you left Donald. The necklace remains shining on the ground.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void chapterThree() {

		position = "chapterThree";

		choice1.setVisible(true);
		choice1.setText("Inspect keys");
		choice2.setVisible(true);
		choice2.setText("Inspect headband");

		storyTextArea.setText(
				"You, Sarah, and Donald each stand a few metres away from the 3rd body. The team of CSIs are already setting up. "
						+ "\nSarah walks over to speak to one of them, leaving you and Donald behind. "
						+ "\nAfter a few moments, Donald moves to join Sarah. \nYou make you're way upstairs. Th body was found in the living room. "
						+ "\nHer room is as you remember, from the posters on the wall to the position of the makeup on the \ndressing table.");

	}

	public void inspectKeys() {

		position = "inspectKeys";

		choice1.setText(">>>>");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Your coat pockets are starting to weigh down. You adjust you coat so it doesn't look too obvious."
						+ "\n\nYou make your way back downstairs.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void inspectHeadband() {

		position = "inspectHeadband";

		choice1.setVisible(false);
		choice2.setVisible(true);
		choice2.setText(">>>>");

		storyTextArea.setText("Once back in the living room, you realise no one noticed you had been upstairs.");

		inventory = inventory + 1;
		inventoryLabelCount.setText("" + inventory);

	}

	public void epiloguePartOne() {

		position = "epiloguePt1";

		choice1.setVisible(true);
		choice1.setText("...");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Donald and Sarah sit opposite you in the booth. \nSarah had asked one the drive back to the station if you wanted to grab something to eat. "
						+ "\nYou agreed. \nWhat you didn't expect was for her and Donald to be sat together in the booth at the back of the cafe. "
						+ "\nYou greet Donald casually hiding your surprise.");

	}

	public void epiloguePartTwo() {

		position = "epiloguePt2";

		choice1.setVisible(true);
		choice1.setText("....");
		choice2.setVisible(false);

		storyTextArea.setText(
				"BREAKING NEWS \nCelebrated sergeant, Thomas Doyle arrested this morning by the two collegues he's worked with for the past five years. "
						+ "\nDoyle was arrested on the suspicion of several women in the past month after being caught taking away small items, "
						+ "thought to be trophies from each crime scene he attended while on duty. \nDoyle was arrested at a cafe when the items he took from the crime scenes spilled out of his pockets.");

	}

	public void epiloguePartThree() {

		position = "epiloguePt3";

		choice1.setVisible(true);
		choice1.setText(".....");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Sarah: Tom, Danielle was taking photographs of all the rooms in that house and \nit's clear as day that you took something from that girl's room when you went upstairs. \nYou remain silent, "
						+ "your pockets a heavt weight on your legs. \nDonald: Why don't you empty out your pockets Tom? It's like Sarah said, Danielle had taken \nphotos before and after you had gone upstairs, I saw you go up.");

	}

	public void epiloguePartFour() {

		position = "epiloguePt4";

		choice1.setVisible(true);
		choice1.setText("......");
		choice2.setVisible(false);

		storyTextArea.setText(
				"Each of the items sits on the cafe table. You start crying, but neither Donald or Sarah show a shred of \nsympathy. Donald is speaking, but you hear none of it even as he stands and "
						+ "comes round the cafe table to stand directly beside you. \nYou are pulled up from your seat, your hands are brought behind your back, and then "
						+ "\nyou feel the air against your face as they lead you outside. There's hand on your head as you made to \nget inside Sarah's car, then the thud of the door closing shut.");

		inventory = 0;
		inventoryLabelCount.setText("" + inventory);
		inventoryLabel.setForeground(Color.red);
		inventoryLabelCount.setForeground(Color.red);

	}

	public void alternateBadEnding() {

		position = "alternateBadEnding";

		choice1.setVisible(false);
		choice2.setVisible(true);
		choice2.setText(".......");

		storyTextArea.setText(
				"Thomas Doyle hangs up his coat, his left hand carrying the contents of his pockets. He walks over to his bookshelf "
						+ "\nand carefully places each item side by side. Some of the other items displayed include earrings, arcade tokens, and a shoelace. "
						+ "\nOnce all the items are place in a straight line, Thomas get's into bed and sleeps for the first time in forty-eight hours.");

	}

	public void gameOutro() {

		position = "gameOutro";

		inventoryPanel.setVisible(false);
		choiceButtonPanel.setVisible(false);
		startContinueButtonPanel.setVisible(false);

		titlePanel.setVisible(true);
		titlePanel.setBounds(10, 100, 1400, 500);
		titleLabel.setText("T H E   E N D");
		titlePanel.setBounds(10, 100, 1800, 1000);
		titleLabel.setFont(titleFont);

	}

	public class TitleScreenHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			gameIntro();

		}

	}

	public class GameIntroHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			prologue();

		}

	}

	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			String playerChoice = event.getActionCommand();

			switch (position) {
			case "prologue":
				switch (playerChoice) {
				case "c1":
					answerPhone();
					break;
				case "c2":
					missedCall();
					break;
				}
				break;
			case "answerPhone":
				switch (playerChoice) {
				case "c1":
					chapterOne();
					break;
				}
				break;
			case "missedCall":
				switch (playerChoice) {
				case "c2":
					chapterOne();
					break;
				}
				break;
			case "chapterOne":
				switch (playerChoice) {
				case "c1":
					inspectHairClip();
					break;
				case "c2":
					inspectLipGloss();
					break;
				}
				break;
			case "inspectHairClip":
				switch (playerChoice) {
				case "c1":
					chapterTwo();
					break;
				}
				break;
			case "inspectLipGloss":
				switch (playerChoice) {
				case "c2":
					chapterTwo();
					break;
				}
				break;
			case "chapterTwo":
				switch (playerChoice) {
				case "c1":
					inspectNecklace();
					break;
				case "c2":
					inspectGlasses();
					break;
				}
				break;
			case "inspectNecklace":
				switch (playerChoice) {
				case "c1":
					chapterThree();
					break;
				}
				break;
			case "inspectGlasses":
				switch (playerChoice) {
				case "c2":
					chapterThree();
					break;
				}
				break;
			case "chapterThree":
				switch (playerChoice) {
				case "c1":
					inspectKeys();
					break;
				case "c2":
					inspectHeadband();
					break;
				}
				break;
			case "inspectKeys":
				switch (playerChoice) {
				case "c1":
					epiloguePartOne();
					break;
				}
				break;
			case "inspectHeadband":
				switch (playerChoice) {
				case "c2":
					alternateBadEnding();
					break;
				}
				break;
			case "epiloguePt1":
				switch (playerChoice) {
				case "c1":
					epiloguePartTwo();
					break;
				}
				break;
			case "epiloguePt2":
				switch (playerChoice) {
				case "c1":
					epiloguePartThree();
					break;
				}
				break;
			case "epiloguePt3":
				switch (playerChoice) {
				case "c1":
					epiloguePartFour();
					break;
				}
				break;
			case "epiloguePt4":
				switch (playerChoice) {
				case "c1":
					gameOutro();
					break;
				}
				break;
			case "alternateBadEnding":
				switch (playerChoice) {
				case "c2":
					gameOutro();
					break;
				}
				break;
			}

		}

	}

}

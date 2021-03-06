/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abp.lab.pkg5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author pmele
 */
public class AminoQuizFrame extends javax.swing.JFrame {
    
    private final static ArrayList<String> SHORT_NAMES = new ArrayList<>( Arrays.asList( new String[] {
        //Labels in comments for easy cheating
        "A", "R", //1
        "N", "D", //2
        "C", "Q", //3
        "E", "G", //4
        "H", "I", //5
        "L", "K", //6
        "M", "F", //7
        "P", "S", //8
        "T", "W", //9
        "Y", "V"  //10
    }));
    
    private final static ArrayList<String> FULL_NAMES = new ArrayList<>( Arrays.asList( new String[] {
        //Labels in comments for easy cheating
        "alanine", "arginine",              //1
        "asparagine", "aspartic acid",      //2
        "cysteine", "glutamine",            //3
        "glutamic acid",  "glycine" ,       //4
        "histidine","isoleucine",           //5
        "leucine",  "lysine",               //6
        "methionine", "phenylalanine",      //7
        "proline", "serine",                //8
        "threonine","tryptophan",           //9
        "tyrosine", "valine"                //10
    }));
    
    private boolean started = false;
    private Boolean ended = false;
    
    private int quizTime = 30000; //In milliseconds -> 30 seconds
    private ArrayList<Integer> usedQuestions = new ArrayList<>();
    private final int NO_REPEAT_BUFFER = 7;
    private int currentCorrectIndex = -1;
    
    private int correctAnswers;
    private int incorrectAnswers;
    
    /**
     * Creates new form AminoQuizFrame
     */
    public AminoQuizFrame() {
        initComponents();
        getRootPane().setDefaultButton(submitButton);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        correctDisplay = new javax.swing.JFormattedTextField();
        incorrectDisplay = new javax.swing.JFormattedTextField();
        promptDisplay = new javax.swing.JLabel();
        aminoDisplay = new javax.swing.JFormattedTextField();
        answerField = new javax.swing.JTextField();
        endButton = new javax.swing.JButton();
        timeDisplay = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        explanationDisplay = new javax.swing.JFormattedTextField();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        submitButton.setFont(submitButton.getFont().deriveFont(submitButton.getFont().getStyle() | java.awt.Font.BOLD, submitButton.getFont().getSize()+3));
        submitButton.setText("Start");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Correct");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Incorrect");

        correctDisplay.setEditable(false);
        correctDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        correctDisplay.setText("0");
        correctDisplay.setToolTipText("Questions correctly answered");
        correctDisplay.setFont(correctDisplay.getFont().deriveFont(correctDisplay.getFont().getStyle() | java.awt.Font.BOLD, correctDisplay.getFont().getSize()+25));

        incorrectDisplay.setEditable(false);
        incorrectDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        incorrectDisplay.setText("0");
        incorrectDisplay.setToolTipText("Questions incorrectly answered");
        incorrectDisplay.setFont(incorrectDisplay.getFont().deriveFont(incorrectDisplay.getFont().getStyle() | java.awt.Font.BOLD, incorrectDisplay.getFont().getSize()+25));

        promptDisplay.setText("What is the full name for the amino acid:");
        promptDisplay.setEnabled(false);

        aminoDisplay.setEditable(false);
        aminoDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        aminoDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aminoDisplay.setText("-");
        aminoDisplay.setEnabled(false);
        aminoDisplay.setFont(aminoDisplay.getFont().deriveFont(aminoDisplay.getFont().getStyle() | java.awt.Font.BOLD, aminoDisplay.getFont().getSize()+15));

        answerField.setText("Hit 'Start' or Enter when ready!");
        answerField.setMargin(new java.awt.Insets(2, 6, 2, 2));

        endButton.setFont(endButton.getFont().deriveFont(endButton.getFont().getStyle() | java.awt.Font.BOLD, endButton.getFont().getSize()+3));
        endButton.setText("End");
        endButton.setEnabled(false);
        endButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endButtonActionPerformed(evt);
            }
        });

        timeDisplay.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        timeDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        timeDisplay.setText("30");

        jLabel3.setText("Seconds:");

        explanationDisplay.setEditable(false);
        explanationDisplay.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        explanationDisplay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        explanationDisplay.setText("-");
        explanationDisplay.setEnabled(false);
        explanationDisplay.setFont(explanationDisplay.getFont());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(promptDisplay)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeDisplay))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(aminoDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(explanationDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(answerField))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(submitButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(correctDisplay, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(incorrectDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                            .addComponent(endButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(incorrectDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                            .addComponent(correctDisplay)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(promptDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(timeDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(aminoDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(explanationDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(endButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(answerField))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    Timer timer;
    Timer countdownTimer;

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if (!started) {
            started = true;
            
            submitButton.setText("Submit");
            promptDisplay.setEnabled(true);
            aminoDisplay.setEnabled(true);
            explanationDisplay.setEnabled(true);
            endButton.setEnabled(true);
            answerField.setText("");
            
            timeDisplay.setEditable(false);
            try {
                quizTime = 1000 * Integer.parseInt(timeDisplay.getText());
            } catch (NumberFormatException e) {
                //If someone enters something invalid
                quizTime = 30000;
                timeDisplay.setText("30");
            }
            timeDisplay.setEnabled(false);
            countdownTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    Integer time = Integer.parseInt(timeDisplay.getText());
                    if (time > 0) {
                        time--;
                        timeDisplay.setText(time + "");
                    }
                }
            });
            timer = new Timer(quizTime, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    synchronized(ended) {
                        if (!ended) {
                            ended = true;
                            endQuiz();
                        }
                    }
                }
            });
            countdownTimer.setRepeats(true);
            timer.setRepeats(false);
            countdownTimer.start();
            timer.start();
        } else {
            updateAnswers(answerField.getText().trim().toLowerCase());
        }
        promptNewQuestion();
    }//GEN-LAST:event_submitButtonActionPerformed

    private void endButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endButtonActionPerformed
        synchronized(ended) {
            if (!ended) {
                ended = true;
                endQuiz();
            } else {
                resetQuiz();
            }
        }
    }//GEN-LAST:event_endButtonActionPerformed

    private void promptNewQuestion() {
        Random rand = new Random();
        int possibleIndex;
        do {
            possibleIndex = rand.nextInt(20);
        } while(usedQuestions.contains(possibleIndex));
        currentCorrectIndex = possibleIndex;
        aminoDisplay.setText(SHORT_NAMES.get(currentCorrectIndex));
        usedQuestions.add(currentCorrectIndex);
        if (usedQuestions.size() > NO_REPEAT_BUFFER) {
            usedQuestions.remove(0);
        }
    }
    
    private void updateAnswers(String answer) {
        if (FULL_NAMES.get(currentCorrectIndex).equals(answer)) {
                correctAnswers++;
                explanationDisplay.setText("Correct!");
            } else {
                incorrectAnswers++;
                explanationDisplay.setText(SHORT_NAMES.get(currentCorrectIndex) + " > " + FULL_NAMES.get(currentCorrectIndex) + "!");
            }
            answerField.setText("");
        correctDisplay.setText(correctAnswers + "");
        incorrectDisplay.setText(incorrectAnswers + "");
    }
    
    private void endQuiz() {
        answerField.setText("Quiz over!");
        answerField.setEnabled(false);
        submitButton.setEnabled(false);
        endButton.setText("Reset");
        correctDisplay.setEnabled(false);
        incorrectDisplay.setEnabled(false);
        explanationDisplay.setEnabled(false);
        aminoDisplay.setEnabled(false);
        countdownTimer.stop();
        timeDisplay.setText("0");
    }
    
    private void resetQuiz() {
        answerField.setText("Hit 'Start' or 'Enter' when ready!");
        answerField.setEnabled(true);
        submitButton.setEnabled(true);
        endButton.setText("End");
        endButton.setEnabled(false);
        submitButton.setText("Start");
        correctDisplay.setText("0");
        incorrectDisplay.setText("0");
        correctDisplay.setEnabled(true);
        incorrectDisplay.setEnabled(true);
        correctAnswers = 0;
        incorrectAnswers = 0;
        timeDisplay.setText("30");
        timeDisplay.setEnabled(true);
        explanationDisplay.setText("-");
        aminoDisplay.setText("-");
        started = false;
        ended = false;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AminoQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AminoQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AminoQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AminoQuizFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AminoQuizFrame().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField aminoDisplay;
    private javax.swing.JTextField answerField;
    private javax.swing.JFormattedTextField correctDisplay;
    private javax.swing.JButton endButton;
    private javax.swing.JFormattedTextField explanationDisplay;
    private javax.swing.JFormattedTextField incorrectDisplay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel promptDisplay;
    private javax.swing.JButton submitButton;
    private javax.swing.JFormattedTextField timeDisplay;
    // End of variables declaration//GEN-END:variables

}

package snake.client;

import java.awt.event.*;

public class SnakeFrame extends javax.swing.JFrame
{
    public SnakeFrame()
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerGroup = new javax.swing.ButtonGroup();
        hostGroup = new javax.swing.ButtonGroup();
        frame_canvas = new SnakeCanvas();
        setPanel = new javax.swing.JPanel();
        multiButton = new javax.swing.JRadioButton();
        hostButton = new javax.swing.JRadioButton();
        joinButton = new javax.swing.JRadioButton();
        ipLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        ipField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        singleButton = new javax.swing.JRadioButton();
        cpuButton = new javax.swing.JCheckBox();
        outputScroll = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        stopButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        sameButton = new javax.swing.JRadioButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake - By Christopher Chamberlain and Abhishek Choudhury");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        frame_canvas.setMinimumSize(new java.awt.Dimension(720, 440));
        frame_canvas.setPreferredSize(new java.awt.Dimension(720, 440));

        setPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Game Setup"));

        playerGroup.add(multiButton);
        multiButton.setText("Multiplayer");
        multiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multiButtonActionPerformed(evt);
            }
        });

        hostGroup.add(hostButton);
        hostButton.setText("Host Game");
        hostButton.setEnabled(false);

        hostGroup.add(joinButton);
        joinButton.setText("Join Game");
        joinButton.setEnabled(false);

        ipLabel.setText("IP Address:");
        ipLabel.setEnabled(false);

        portLabel.setText("Port:");
        portLabel.setEnabled(false);

        ipField.setEnabled(false);

        portField.setText("27010");
        portField.setEnabled(false);

        playerGroup.add(singleButton);
        singleButton.setSelected(true);
        singleButton.setText("Single Player");
        singleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleButtonActionPerformed(evt);
            }
        });

        cpuButton.setText("Against CPU");
        cpuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpuButtonActionPerformed(evt);
            }
        });

        outputScroll.setEnabled(false);

        outputArea.setEditable(false);
        outputArea.setColumns(20);
        outputArea.setRows(4);
        outputScroll.setViewportView(outputArea);

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        hostGroup.add(sameButton);
        sameButton.setSelected(true);
        sameButton.setText("Same Screen");
        sameButton.setEnabled(false);

        javax.swing.GroupLayout setPanelLayout = new javax.swing.GroupLayout(setPanel);
        setPanel.setLayout(setPanelLayout);
        setPanelLayout.setHorizontalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(singleButton))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cpuButton)))
                        .addGap(18, 18, 18)
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(multiButton)
                            .addComponent(sameButton))
                        .addGap(15, 15, 15)
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(joinButton)
                                .addGap(18, 18, 18)
                                .addComponent(portLabel)
                                .addGap(38, 38, 38)
                                .addComponent(portField))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addComponent(hostButton)
                                .addGap(18, 18, 18)
                                .addComponent(ipLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(outputScroll)
                .addContainerGap())
        );
        setPanelLayout.setVerticalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(outputScroll, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(multiButton)
                            .addComponent(hostButton)
                            .addComponent(ipLabel)
                            .addComponent(ipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(singleButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(joinButton)
                            .addComponent(portLabel)
                            .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cpuButton)
                            .addComponent(sameButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stopButton)
                            .addComponent(startButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(frame_canvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(setPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frame_canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        startButton.setEnabled(false);
        frame_canvas.requestFocus();
        stopButton.setEnabled(true);
        if (singleButton.isEnabled())
        {
            if (cpuButton.isEnabled())
            {
                //snake.server.SnakeGame.startGame(snake.server.SnakeGame.SINGLE_WITH_BOT);
                return;
            }
            //snake.server.SnakeGame.startGame(snake.server.SnakeGame.SINGLE);
            return;
        }
        if (multiButton.isEnabled())
        {
            if (hostButton.isEnabled())
                return;
                //SnakeGame.startGame(SnakeGame.MULTI_HOST);
            if (joinButton.isEnabled())
                return;
                //SnakeGame.startGame(SnakeGame.MULTI_JOIN);
            if (sameButton.isEnabled())
                return;
                //SnakeGame.startGame(SnakeGame.MULTI_SAME_SCREEN);
        }
        
    }//GEN-LAST:event_startButtonActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        SnakeGame.stopGame();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void cpuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpuButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpuButtonActionPerformed

    private void multiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiButtonActionPerformed
        hostButton.setEnabled(true);
        ipField.setEnabled(true);
        joinButton.setEnabled(true);
        portField.setEnabled(true);
        sameButton.setEnabled(true);
        ipLabel.setEnabled(true);
        portLabel.setEnabled(true);
        
        cpuButton.setEnabled(false);
    }//GEN-LAST:event_multiButtonActionPerformed

    private void singleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleButtonActionPerformed
        hostButton.setEnabled(false);
        ipField.setEnabled(false);
        joinButton.setEnabled(false);
        portField.setEnabled(false);
        sameButton.setEnabled(false);
        ipLabel.setEnabled(false);
        portLabel.setEnabled(false);
        
        cpuButton.setEnabled(true);
    }//GEN-LAST:event_singleButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SnakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SnakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SnakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SnakeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SnakeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cpuButton;
    private java.awt.Canvas frame_canvas;
    private javax.swing.JRadioButton hostButton;
    private javax.swing.ButtonGroup hostGroup;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JRadioButton joinButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JRadioButton multiButton;
    private javax.swing.JTextArea outputArea;
    private javax.swing.JScrollPane outputScroll;
    private javax.swing.ButtonGroup playerGroup;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JRadioButton sameButton;
    private javax.swing.JPanel setPanel;
    private javax.swing.JRadioButton singleButton;
    public javax.swing.JButton startButton;
    public javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}

package snake.client;

import java.awt.event.*;
import javax.swing.*;
import java.time.Instant;

public class SnakeFrame extends javax.swing.JFrame
{
    public SnakeFrame()
    {
        initComponents();
    }
    
    public void clientOut(String text)
    {
        clientOut.setText(clientOut.getText() + text + '\n');
        JScrollBar bar = clientScroll.getVerticalScrollBar();
        bar.setValue(bar.getMaximum());
    }
    public void flushClient()
    {
        clientOut.setText("");
    }
    
    public void serverOut(String text)
    {
        serverOut.setText(serverOut.getText() + text + '\n');
        JScrollBar bar = serverScroll.getVerticalScrollBar();
        bar.setValue(bar.getMaximum());
    }
    public void flushServer()
    {
        serverOut.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerGroup = new javax.swing.ButtonGroup();
        hostGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        gameTab = new javax.swing.JPanel();
        frame_canvas = new SnakeCanvas();
        startButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        clientScroll = new javax.swing.JScrollPane();
        clientOut = new javax.swing.JTextArea();
        setTab = new javax.swing.JPanel();
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
        sameButton = new javax.swing.JRadioButton();
        pathLabel = new javax.swing.JLabel();
        pathBox = new javax.swing.JComboBox<>();
        serverScroll = new javax.swing.JScrollPane();
        serverOut = new javax.swing.JTextArea();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake - By Christopher Chamberlain and Abhishek Choudhury");
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        frame_canvas.setMinimumSize(new java.awt.Dimension(720, 440));

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.setEnabled(false);
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        clientOut.setEditable(false);
        clientOut.setColumns(20);
        clientOut.setRows(5);
        clientScroll.setViewportView(clientOut);

        javax.swing.GroupLayout gameTabLayout = new javax.swing.GroupLayout(gameTab);
        gameTab.setLayout(gameTabLayout);
        gameTabLayout.setHorizontalGroup(
            gameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(frame_canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gameTabLayout.createSequentialGroup()
                        .addGroup(gameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startButton)
                            .addComponent(stopButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientScroll)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gameTabLayout.setVerticalGroup(
            gameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gameTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(frame_canvas, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gameTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gameTabLayout.createSequentialGroup()
                        .addComponent(startButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopButton))
                    .addComponent(clientScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Snake", gameTab);

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
        hostButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hostButtonActionPerformed(evt);
            }
        });

        hostGroup.add(joinButton);
        joinButton.setText("Join Game");
        joinButton.setEnabled(false);
        joinButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinButtonActionPerformed(evt);
            }
        });

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

        hostGroup.add(sameButton);
        sameButton.setSelected(true);
        sameButton.setText("Same Screen");
        sameButton.setEnabled(false);
        sameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sameButtonActionPerformed(evt);
            }
        });

        pathLabel.setText("Pathfinder:");

        pathBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Simple", "Random" }));

        javax.swing.GroupLayout setPanelLayout = new javax.swing.GroupLayout(setPanel);
        setPanel.setLayout(setPanelLayout);
        setPanelLayout.setHorizontalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setPanelLayout.createSequentialGroup()
                        .addGroup(setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(singleButton))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cpuButton))
                            .addGroup(setPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pathLabel)))
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
                        .addContainerGap()
                        .addComponent(pathBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        setPanelLayout.setVerticalGroup(
            setPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setPanelLayout.createSequentialGroup()
                .addContainerGap()
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pathBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        serverScroll.setBorder(javax.swing.BorderFactory.createTitledBorder("Server Output"));

        serverOut.setEditable(false);
        serverOut.setColumns(20);
        serverOut.setRows(5);
        serverScroll.setViewportView(serverOut);

        javax.swing.GroupLayout setTabLayout = new javax.swing.GroupLayout(setTab);
        setTab.setLayout(setTabLayout);
        setTabLayout.setHorizontalGroup(
            setTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(setTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(setTabLayout.createSequentialGroup()
                        .addComponent(setPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(serverScroll, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        setTabLayout.setVerticalGroup(
            setTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(setTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(setPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", setTab);

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
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void multiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multiButtonActionPerformed
        hostButton.setEnabled(true);
        joinButton.setEnabled(true);
        sameButton.setEnabled(true);
        
        if (hostButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (joinButton.isSelected())
        {
            ipLabel.setEnabled(true);
            ipField.setEnabled(true);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (sameButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(false);
            portField.setEnabled(false);
        }
        
        cpuButton.setEnabled(false);
        pathLabel.setEnabled(false);
        pathBox.setEnabled(false);
    }//GEN-LAST:event_multiButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        flushClient();
        flushServer();
        
        startButton.setEnabled(false);
        frame_canvas.requestFocus();
        stopButton.setEnabled(true);
        if (singleButton.isSelected())
        {
            if (cpuButton.isSelected())
            {
                snake.server.SnakeServer s = new snake.server.SnakeServer(SnakeGame.SINGLE_WITH_BOT, 27010);
                s.start();
                
                snake.client.SnakeClient.connect("127.0.0.1", 27010);
                return;
            }
            //Start Server
            //snake.server.SnakeGame.startGame(snake.server.SnakeGame.SINGLE, 27010);
            snake.server.SnakeServer s = new snake.server.SnakeServer(SnakeGame.SINGLE, 27010);
            s.start();
            
            //Start host computer's client
            snake.client.SnakeClient.connect("127.0.0.1", 27010);
            //snake.server.SnakeServer.sendStart(Instant.now().toEpochMilli());
            return;
        }
        if (multiButton.isSelected())
        {
            String hostname = ipField.getText();
            int port = Integer.parseInt(portField.getText());
            
            if (hostButton.isSelected())
            {
                //snake.server.SnakeGame.startGame(snake.server.SnakeGame.MULTI_HOST, port);
                snake.server.SnakeServer s = new snake.server.SnakeServer(SnakeGame.MULTI_HOST, 27010);
                s.start();
                
                //Start host computer's client
                snake.client.SnakeClient.connect("127.0.0.1", port);
                //snake.server.SnakeServer.sendStart(Instant.now().toEpochMilli());
            }
            if (joinButton.isSelected())
            {
                //Start host computer's client
                snake.client.SnakeClient.connect(hostname, port);
            }
            if (sameButton.isSelected())
            {
                snake.server.SnakeServer s = new snake.server.SnakeServer(SnakeGame.MULTI_SAME_SCREEN, 27010);
                s.start();
                
                snake.client.SnakeClient.connect("127.0.0.1", port);
            }
        }
    }//GEN-LAST:event_startButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        SnakeGame.stopGame();
    }//GEN-LAST:event_stopButtonActionPerformed

    private void singleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleButtonActionPerformed
        hostButton.setEnabled(false);
        ipField.setEnabled(false);
        joinButton.setEnabled(false);
        portField.setEnabled(false);
        sameButton.setEnabled(false);
        ipLabel.setEnabled(false);
        portLabel.setEnabled(false);

        cpuButton.setEnabled(true);
        pathLabel.setEnabled(true);
        pathBox.setEnabled(true);
    }//GEN-LAST:event_singleButtonActionPerformed

    private void sameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sameButtonActionPerformed
        if (hostButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (joinButton.isSelected())
        {
            ipLabel.setEnabled(true);
            ipField.setEnabled(true);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (sameButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(false);
            portField.setEnabled(false);
        }
    }//GEN-LAST:event_sameButtonActionPerformed

    private void joinButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinButtonActionPerformed
        if (hostButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (joinButton.isSelected())
        {
            ipLabel.setEnabled(true);
            ipField.setEnabled(true);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (sameButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(false);
            portField.setEnabled(false);
        }
    }//GEN-LAST:event_joinButtonActionPerformed

    private void hostButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hostButtonActionPerformed
        if (hostButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (joinButton.isSelected())
        {
            ipLabel.setEnabled(true);
            ipField.setEnabled(true);
            portLabel.setEnabled(true);
            portField.setEnabled(true);
        } else if (sameButton.isSelected())
        {
            ipLabel.setEnabled(false);
            ipField.setEnabled(false);
            portLabel.setEnabled(false);
            portField.setEnabled(false);
        }
    }//GEN-LAST:event_hostButtonActionPerformed

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
    private javax.swing.JTextArea clientOut;
    private javax.swing.JScrollPane clientScroll;
    private javax.swing.JCheckBox cpuButton;
    private java.awt.Canvas frame_canvas;
    private javax.swing.JPanel gameTab;
    private javax.swing.JRadioButton hostButton;
    private javax.swing.ButtonGroup hostGroup;
    private javax.swing.JTextField ipField;
    private javax.swing.JLabel ipLabel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton joinButton;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JRadioButton multiButton;
    public javax.swing.JComboBox<String> pathBox;
    private javax.swing.JLabel pathLabel;
    private javax.swing.ButtonGroup playerGroup;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JRadioButton sameButton;
    private javax.swing.JTextArea serverOut;
    private javax.swing.JScrollPane serverScroll;
    private javax.swing.JPanel setPanel;
    private javax.swing.JPanel setTab;
    private javax.swing.JRadioButton singleButton;
    public javax.swing.JButton startButton;
    public javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables
}

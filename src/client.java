/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package src;

/**
 *
 * @author Kyle
 */
public class client extends javax.swing.JFrame {

	boolean CommandMode = false;
	boolean _newGameOutput = false;
	String _Observe = "";
	String _StatsInventory="";
	String UserInput = "";
    /**
     * Creates new form client
     */
    public client() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        input = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputBox = new javax.swing.JTextArea();
        jToolBar1 = new javax.swing.JToolBar();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadSaveButton = new javax.swing.JMenuItem();
        SaveButton = new javax.swing.JMenuItem();
        ExitButton = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        AboutButton = new javax.swing.JMenuItem();
        PlayerGuideButton = new javax.swing.JMenuItem();
        GameManualButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(true);

        input.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        input.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputActionPerformed(evt);
            }
        });

        outputBox.setEditable(false);
        outputBox.setColumns(20);
        outputBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        outputBox.setLineWrap(true);
        outputBox.setRows(5);
        outputBox.setWrapStyleWord(true);
        outputBox.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        outputBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(outputBox);

        jToolBar1.setRollover(true);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane2.setViewportView(jTextArea1);

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setWrapStyleWord(true);
        jTextArea2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(jTextArea2);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu1.setText("File");

        LoadSaveButton.setText("Load");
        LoadSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadSaveButtonActionPerformed(evt);
            }
        });
        jMenu1.add(LoadSaveButton);

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });
        jMenu1.add(SaveButton);

        ExitButton.setText("Exit");
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        jMenu1.add(ExitButton);

        jMenuBar1.add(jMenu1);

        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setText("Help");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        AboutButton.setText("About");
        AboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutButtonActionPerformed(evt);
            }
        });
        jMenu2.add(AboutButton);

        PlayerGuideButton.setText("Player Guide");
        PlayerGuideButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayerGuideButtonActionPerformed(evt);
            }
        });
        jMenu2.add(PlayerGuideButton);

        GameManualButton.setText("Game Manual");
        GameManualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameManualButtonActionPerformed(evt);
            }
        });
        jMenu2.add(GameManualButton);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void inputActionPerformed(java.awt.event.ActionEvent evt) {                                      
        //Place command input here
    	UserInput=input.getText();
    	CommandMode=true;
    }                                     

    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        dispose();
        // add more logic to make game actually close.
    }                                          

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
    }                                      

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // Add saving the game here.
    }                                          

    private void LoadSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // Add loading a previous save here.
    }                                              

    private void GameManualButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // Launch an html or pdf manual for the game.
    }                                                

    private void PlayerGuideButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // Either launch to a short section in the above manual or launch a seperate html or pdf for the guide.
    }                                                 

    private void AboutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // Launch the about&license window.
    }                                           

    
    public void ClearInputBox() {
    	input.setText("");
    }
   
    public void SceneDungeonOutput(String output) {
    	jTextArea2.setText(output);
    }
    
    public void SceneOutputAppend(String output) {
    	jTextArea2.append(output);	
    }
    
    public void SceneOutput(String output) {
    	if (_newGameOutput==false) {
    		//jTextArea2.setText(jTextArea2.getText()+output);
    		jTextArea2.setText(output);
    	} else if (_newGameOutput==true) {
    		jTextArea2.setText("You awake in the distants lands of Elysium and worse lost in its wilderness...\n");
    	}
    }
    public void Observe() {
    	jTextArea2.append(_Observe);
    }
    public void StatsAndInventoryUpdate() {
    	jTextArea1.setText(_StatsInventory);
    }
    public void SceneUpdate(int x, int y) {
    	boolean _done=false;    	
    	if ((x==8)&&(y==1)) {
    		jTextArea2.setText("You stumble upon an old mine. Ancient minecarts litter the area, some even on cliff faces above the mine...");
    		_done=true;
    	}else if ((x==2)&&(y==2)) {
    		jTextArea2.setText("You find the crumbling ruins of an old fort. Almost nothing of it remains.");
    		_done=true;
    	}else if ((x==3)&&(y==5)) {
        	jTextArea2.setText("You find the entrance of a cave, which is also at the foot of a small mountain.\n");
        	_done = true;
    	}
    	if ((x==3)&&(y==6)) {
    		jTextArea2.setText("You cannot cross the mountain. Go around or enter the cave.");
    		_done = true;
    	}
    	if ((x==3)&&(y==7)) {
    		jTextArea2.setText("You find the entrance of a cave, which is also at the foot of a small mountain.\n");
    		_done = true;
    	}
    	if (_done != true) {
    		jTextArea2.setText("You arrive at an uninteresting spot.");
    		_done = true;
    	}
    	_done=false;
    }
    
    public void GenericOutputBoxOut(String output) {
    	outputBox.append(output+"\n");
    	outputBox.setCaretPosition(outputBox.getDocument().getLength());
    }
    public void GenericOutputBoxOut2(String output) {
    	outputBox.setText(output+"\n");
    	outputBox.setCaretPosition(outputBox.getDocument().getLength());
    }
    
    
    public void HelpOut(String output) {
    	outputBox.setText(outputBox.getText()+"\n"+output);
    }
    
    public void EquipItemOut(int condition, String name) {
    	if (condition==0) {
    		String output = "You have equipped your "+name;
        	outputBox.setText(outputBox.getText()+"\n"+output);
    	} else if (condition==1) {
    		String output = "That weapon was not in your inventory.";
        	outputBox.setText(outputBox.getText()+"\n"+output);
    	} else if (condition==2) {
    		String output = "Please specify what weapon you want to equip.";
        	outputBox.setText(outputBox.getText()+"\n"+output);
    	} else if (condition==3) {
    		String output = "Unequipping "+name;
        	outputBox.setText(outputBox.getText()+"\n"+output);
    	}
    	
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
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JMenuItem AboutButton;
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenuItem GameManualButton;
    private javax.swing.JMenuItem LoadSaveButton;
    private javax.swing.JMenuItem PlayerGuideButton;
    private javax.swing.JMenuItem SaveButton;
    private javax.swing.JTextField input;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTextArea outputBox;
    // End of variables declaration                   
}
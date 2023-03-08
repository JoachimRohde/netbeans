/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.cordova.options;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.modules.cordova.CordovaPlatform;
import org.netbeans.modules.cordova.CordovaPlatform.Version;
import org.netbeans.modules.cordova.platforms.spi.MobilePlatform;
import org.netbeans.modules.cordova.platforms.api.PlatformManager;
import org.netbeans.modules.cordova.platforms.spi.ProvisioningProfile;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.awt.HtmlBrowser.URLDisplayer;
import org.openide.filesystems.FileChooserBuilder;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.util.RequestProcessor;
import org.openide.util.Utilities;

@OptionsPanelController.Keywords(keywords={"#KW.MobilePlatformsPanel"}, location="Html5", tabTitle= "Mobile Platforms")
final class MobilePlatformsPanel extends javax.swing.JPanel {

    private final MobilePlatformsOptionsPanelController controller;
    private DocumentListener documentL;
    private String codeSignIdentity;
    private Collection<? extends ProvisioningProfile> provisioningProfiles = Collections.emptyList();
    private String provisioningProfilePath;
    private boolean inited = false;
    private RequestProcessor.Task versionTask;

    @NbBundle.Messages("LBL_PleaseWait=Please Wait...")
    MobilePlatformsPanel(MobilePlatformsOptionsPanelController controller) {
        this.controller = controller;
        setLayout(new BorderLayout());
        add(new JLabel(Bundle.LBL_PleaseWait(), JLabel.CENTER), BorderLayout.CENTER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        provisioningBrowse = new javax.swing.JButton();
        androidPanel = new javax.swing.JPanel();
        androidSdkLabel = new javax.swing.JLabel();
        androidSdkField = new javax.swing.JTextField();
        androidSdkBrowse = new javax.swing.JButton();
        androidSdkDownload = new javax.swing.JLabel();
        androidVersion = new javax.swing.JLabel();
        envVarWarnLabel = new javax.swing.JLabel();
        iOSPanel = new javax.swing.JPanel();
        identityLabel = new javax.swing.JLabel();
        identityTextField = new javax.swing.JTextField();
        provisioningProfile = new javax.swing.JLabel();
        provisioningCombo = new javax.swing.JComboBox();
        cordovaVersionLabel = new javax.swing.JLabel();
        cordovaPathField = new javax.swing.JTextField();
        cordovaVersionBrowse = new javax.swing.JButton();
        cordovaPathLabel = new javax.swing.JLabel();
        cordovaPathDescLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(provisioningBrowse, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.androidSdkBrowse.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(androidSdkLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.androidSdkLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(androidSdkBrowse, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.androidSdkBrowse.text")); // NOI18N
        androidSdkBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                androidSdkBrowseActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(androidSdkDownload, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.androidSdkDownload.text")); // NOI18N
        androidSdkDownload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                androidSdkDownloadMouseClicked(evt);
            }
        });

        envVarWarnLabel.setForeground(new java.awt.Color(255, 0, 0));
        org.openide.awt.Mnemonics.setLocalizedText(envVarWarnLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.envVarWarnLabel.text")); // NOI18N

        javax.swing.GroupLayout androidPanelLayout = new javax.swing.GroupLayout(androidPanel);
        androidPanel.setLayout(androidPanelLayout);
        androidPanelLayout.setHorizontalGroup(
            androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(androidPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(androidPanelLayout.createSequentialGroup()
                        .addComponent(androidSdkLabel)
                        .addGap(6, 6, 6)
                        .addGroup(androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(androidPanelLayout.createSequentialGroup()
                                .addComponent(androidSdkField)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(androidSdkBrowse))
                            .addGroup(androidPanelLayout.createSequentialGroup()
                                .addComponent(androidVersion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(androidSdkDownload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(envVarWarnLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        androidPanelLayout.setVerticalGroup(
            androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(androidPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(androidSdkLabel)
                    .addComponent(androidSdkField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(androidSdkBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(androidPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(androidSdkDownload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(androidVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(envVarWarnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        org.openide.awt.Mnemonics.setLocalizedText(identityLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.identityLabel.text")); // NOI18N

        identityTextField.setText("iPhone Developer");

        org.openide.awt.Mnemonics.setLocalizedText(provisioningProfile, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.provisioningProfile.text")); // NOI18N

        provisioningCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                provisioningComboItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout iOSPanelLayout = new javax.swing.GroupLayout(iOSPanel);
        iOSPanel.setLayout(iOSPanelLayout);
        iOSPanelLayout.setHorizontalGroup(
            iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iOSPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identityLabel)
                    .addComponent(provisioningProfile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(identityTextField)
                    .addComponent(provisioningCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );
        iOSPanelLayout.setVerticalGroup(
            iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iOSPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(identityLabel)
                    .addComponent(identityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(iOSPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(provisioningProfile)
                    .addComponent(provisioningCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.openide.awt.Mnemonics.setLocalizedText(cordovaVersionLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "LBL_Cordova_Version")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cordovaVersionBrowse, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.cordovaVersionBrowse.text")); // NOI18N
        cordovaVersionBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cordovaVersionBrowseActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(cordovaPathLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.cordovaPathLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cordovaPathDescLabel, org.openide.util.NbBundle.getMessage(MobilePlatformsPanel.class, "MobilePlatformsPanel.cordovaPathDescLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(androidPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(iOSPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cordovaVersionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cordovaPathLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cordovaPathDescLabel)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cordovaPathField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cordovaVersionBrowse)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(androidPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(iOSPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cordovaVersionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cordovaPathField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cordovaPathLabel)
                    .addComponent(cordovaVersionBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cordovaPathDescLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    @NbBundle.Messages("LBL_AndroidPath=Choose Android SDK directory")
    private void androidSdkBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_androidSdkBrowseActionPerformed
        File sdkDir = new FileChooserBuilder(MobilePlatformsPanel.class).setDirectoriesOnly(true).setTitle(Bundle.LBL_AndroidPath()).showOpenDialog();
        if (sdkDir != null) {
            androidSdkField.setText(sdkDir.getAbsolutePath());
        }
    }//GEN-LAST:event_androidSdkBrowseActionPerformed

    private void androidSdkDownloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_androidSdkDownloadMouseClicked
        try {
            URLDisplayer.getDefault().showURL(new URL("http://developer.android.com/sdk/index.html"));//NOI18N
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }//GEN-LAST:event_androidSdkDownloadMouseClicked

    private void provisioningComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_provisioningComboItemStateChanged
        fireChanged();
    }//GEN-LAST:event_provisioningComboItemStateChanged

    private void cordovaVersionBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cordovaVersionBrowseActionPerformed
        
    }//GEN-LAST:event_cordovaVersionBrowseActionPerformed

    void load() {
        final MobilePlatform iosPlatform = PlatformManager.getPlatform(PlatformManager.IOS_TYPE);
        if (iosPlatform != null) {
            codeSignIdentity = iosPlatform.getCodeSignIdentity();
            provisioningProfiles = iosPlatform.getProvisioningProfiles();
            provisioningProfilePath = iosPlatform.getProvisioningProfilePath();
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setupComponenets();
                loadVersion(0);
            }
        });
    }

    private void loadVersion(int delay) {
        if(versionTask == null) {
            versionTask = new RequestProcessor("MobilePlatformOptions").create(new Runnable() {
                @Override
                public void run() {
                    final Version cordovaVersion = CordovaPlatform.getDefault().getVersion(cordovaPathField.getText());
                    if (cordovaVersion != null) {
                        CordovaPlatform.getDefault().isReady();
                    }
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            displayCordovaVersion(cordovaVersion);
                        }
                    });
                }
            });
        }
        versionTask.schedule(delay);
    }

    void setupComponenets() {
        if (!inited) {
            removeAll();
            initComponents();
            MobilePlatform iosPlatform = PlatformManager.getPlatform(PlatformManager.IOS_TYPE);
            if (iosPlatform == null) {
                iOSPanel.setVisible(false);
            }

            cordovaPathField.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    update();
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    update();
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    update();
                }
                private void update() {
                    loadVersion(1000);
                }
            });
            
            boolean androidHomeSet = System.getenv("ANDROID_HOME") != null; //NOI18N
            envVarWarnLabel.setVisible(Utilities.isUnix() && !Utilities.isMac() && !androidHomeSet);
            documentL = new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    fireChanged();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    fireChanged();
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    fireChanged();
                }
            };

            identityTextField.setEnabled(Utilities.isMac());
            provisioningCombo.setEnabled(Utilities.isMac());
            inited = true;
        }
        
        if (documentL != null) {
            androidSdkField.getDocument().removeDocumentListener(documentL);
        }
        androidSdkField.setText(PlatformManager.getPlatform(PlatformManager.ANDROID_TYPE).getSdkLocation());
//        cordovaSdkField.setText(CordovaPlatform.getDefault().getSdkLocation());
        
        identityTextField.setText(codeSignIdentity);
        provisioningCombo.setModel(new DefaultComboBoxModel(provisioningProfiles.toArray()));
        
        for (ProvisioningProfile prof:provisioningProfiles) {
            if (prof.getPath().equals(provisioningProfilePath)) {
                provisioningCombo.setSelectedItem(prof);
            }
        }

        androidSdkField.getDocument().addDocumentListener(documentL);
        identityTextField.getDocument().addDocumentListener(documentL);
        validate();
   }

    private void displayCordovaVersion(Version cordovaVersion) {
        if (cordovaVersion != null) {
            cordovaVersionLabel.setText(NbBundle.getMessage(MobilePlatformsPanel.class, "LBL_Cordova_Version", cordovaVersion.getApiVersion().toString())); //NOI18N
            cordovaVersionLabel.setForeground(cordovaPathLabel.getForeground());
        } else {            
            cordovaVersionLabel.setText(NbBundle.getMessage(MobilePlatformsPanel.class, "LBL_Cordova_Not_Found")); //NOI18N
            cordovaVersionLabel.setForeground(Color.red);
        }
    }

    private void fireChanged() {
        MobilePlatform androidPlatform = PlatformManager.getPlatform(PlatformManager.ANDROID_TYPE);
        String sdkLocation = androidPlatform == null ? "" : androidPlatform.getSdkLocation();
        if (sdkLocation == null) {
            sdkLocation = "";
        }
        boolean isChanged = !sdkLocation.equals(androidSdkField.getText().trim());
        if (identityTextField.isEnabled()) {
            MobilePlatform iosPlatform = PlatformManager.getPlatform(PlatformManager.IOS_TYPE);
            String signIdentity = iosPlatform == null ? "" : iosPlatform.getCodeSignIdentity();
            isChanged |= !signIdentity.equals(identityTextField.getText().trim());
            ProvisioningProfile prov = (ProvisioningProfile) provisioningCombo.getSelectedItem();
            if (prov != null && iosPlatform != null) {
                isChanged |= !iosPlatform.getProvisioningProfilePath().equals(prov.getPath());
            }
        }
        controller.changed(isChanged);
    }

    void store() {
        final MobilePlatform androidPlatform = PlatformManager.getPlatform(PlatformManager.ANDROID_TYPE);
        if (androidPlatform != null && androidSdkField != null) {
            androidPlatform.setSdkLocation(androidSdkField.getText());
        }
        final MobilePlatform iOSPlatform = PlatformManager.getPlatform(PlatformManager.IOS_TYPE);
        if (iOSPlatform != null && identityTextField != null && provisioningCombo != null) {
            iOSPlatform.setCodeSignIdentity(identityTextField.getText());
            final ProvisioningProfile prov = (ProvisioningProfile) provisioningCombo.getSelectedItem();
            if (prov != null) {
                iOSPlatform.setProvisioningProfilePath(prov.getPath());
            }
        }
    }

    @NbBundle.Messages(
            "ERR_NoAndroid=Android SDK not found."
            )
    boolean valid() {
        if (!inited) {
            //panel is loading
            return true;
        }
        File androidLoc = new File(androidSdkField.getText());
        File androidTools = new File(androidLoc, "platform-tools"); //NOI18N
        boolean adroidValid = androidSdkField.getText().isEmpty() || (androidLoc.exists() && androidLoc.isDirectory()
                               && androidTools.exists() && androidTools.isDirectory());
        
        if (!adroidValid) {
            androidVersion.setText(Bundle.ERR_NoAndroid());
            androidVersion.setForeground(Color.red);
        } else {
            androidVersion.setText("");
            androidVersion.setForeground(UIManager.getColor("Label.foreground")); // NOI18N
        }
        return adroidValid;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel androidPanel;
    private javax.swing.JButton androidSdkBrowse;
    private javax.swing.JLabel androidSdkDownload;
    private javax.swing.JTextField androidSdkField;
    private javax.swing.JLabel androidSdkLabel;
    private javax.swing.JLabel androidVersion;
    private javax.swing.JLabel cordovaPathDescLabel;
    private javax.swing.JTextField cordovaPathField;
    private javax.swing.JLabel cordovaPathLabel;
    private javax.swing.JButton cordovaVersionBrowse;
    private javax.swing.JLabel cordovaVersionLabel;
    private javax.swing.JLabel envVarWarnLabel;
    private javax.swing.JPanel iOSPanel;
    private javax.swing.JLabel identityLabel;
    private javax.swing.JTextField identityTextField;
    private javax.swing.JButton provisioningBrowse;
    private javax.swing.JComboBox provisioningCombo;
    private javax.swing.JLabel provisioningProfile;
    // End of variables declaration//GEN-END:variables

}

**How to install jenkin on ubuntu **

1. UPDATE SYSTEM PACAGES ::
    First, ensure your system package are up-to-date:----->
   
             sudo apt update
             sudo apt upgrade -y
   
3. INSTALL JAVA:---------------->
   jenkins requires java to run. Install openjdk
   
             sudo apt install openjdk-11-jdk -y
   
5. VERIFY JAVA:----------------->
   
             java -version
   
7. ADD JENKINS REPOSITORY:------------->
     add the jenis repository to your system:::
   
            wget -q -O - https://pkg.jenkins.io/debian/jenkins.io.key | sudo apt-key add -
   
     then , add the repositroy to your sources list:::
   
             sudo sh -c 'echo deb http://pkg.jenkins.io/debian-stable binary/ > /etc/apt/sources.list.d/jenkins.list'

--------------------------------TROUBLESHOOTING -------------------------------------------------------------------------
ERROR: W: GPG error: https://pkg.jenkins.io/debian-stable binary/ Release: The following signatures couldn't be verified because the public key is not available: NO_PUBKEY 5BA31D57EF5975CA

SOLUTION:-------->
         The error message you're seeing indicates that the public key for the Jenkins repository couldn't be verified. 
         This usually happens if the key hasn't been correctly added to your system or if the repository has been updated with a new key.

        Here's how to resolve the issue:

1. Manually Add the Missing Public Key
You can manually add the missing public key using the following command:--------------->

                          sudo apt-key adv --keyserver keyserver.ubuntu.com --recv-keys 5BA31D57EF5975CA
   
This command retrieves the missing key from the keyserver and adds it to your system's list of trusted keys.

3. Update Your System Again
After adding the key, update your package list:

                                                                 sudo apt update
   
5. Install Jenkins
If the update succeeds without errors, proceed with the installation:

                                                               sudo apt install jenkins -y

-----------------------HERE SUCCESSFULLY DOWNLOAD JENKINS----------------------------------
Now START AND ENABLE JENKINS:

                                        sudo systemctl start jenkins
                                        sudo systemctl enable jenkins
                                        
NOW ADJUST FIREWALL :

                                        sudo ufw allow 8080
                                        

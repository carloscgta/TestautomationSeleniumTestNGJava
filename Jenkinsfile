 /*======================================================================================*
 * Pipeline scope sugested for the Regression Tests for: http://automationpractice.com/index.php on Jenkins CI/CD
 * Author: Carlos Almeida 	
 * Job Execution: once every two hours every weekday (perhaps at 9:38 AM, 11:38 AM, 1:38 PM, 3:38 PM)
 *https://jenkins.io/doc/book/pipeline/
 *=======================================================================================*/
pipeline {
 
  agent any
  
  triggers {
        cron('H 9-16/2 * * 1-5')
    }

  stages {

      stage('Copy chromedriver to the project folder') {
      steps {
        
       
          echo "- copy chromedriver de /usr/local/bin to  path  ./Testautomation/drivers "
       
         
            script {
          
             sh (script: "mkdir -p ./Testautomation/drivers; cp /usr/local/bin/chromedriver ./Testautomation/drivers; mkdir ./Testautomation/drivers ")
             
            
        }
 
    }
    }
    
    stage('Executing automated regression tests') {
      steps {
       
          echo "Running the Selenium Tests
          script {
    sh (script: "mvn clean install")
            
          }
        }
     
    }
 
      
    stage('Notify on Slack') {
      steps {
       
          echo "Notify the execution"
          script {
   
             slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#qa-chat-alpha-sense - Chat name', color: 'good', message: 'Automated Tests Run - Check Build Artifcats for Evidence', teamDomain: 'alpha-sense', token: 'TokenPasteHere'
            
          }
        }
     
    }
   
  }
  
  post {
        
           always {
          		echo 'Publish Evidences-Reports on Jenkins'
              
            script {

            sh (script: "tar -czvf emailable-report.tar.gz ./Testautomation/test-output/emailable-report.html ./Testautomation/evidences; ls -l ./Testautomation/evidences")
            
             archiveArtifacts artifacts: 'emailable-report.tar.gz', fingerprint: true 
             cleanWs();
      		
          }
	 }
       	 
           failure {
           echo 'I failed :('
              script: sendMessage("There failure in the test exeuction ")
         
           script {
            
            sh (script: "tar -czvf emailable-report.tar.gz ./Testautomation/test-output/emailable-report.html ./Testautomation/evidences; ls -l ./Testautomation/evidences")
            
             archiveArtifacts artifacts: 'emailable-report.tar.gz', fingerprint: true 
  		
          }
       	 
       	 }
       	 success {
           echo ' Build Success!! - test executed with Success'
              
       	            
            script {
                slackSend baseUrl: 'https://hooks.slack.com/services/', channel: '#qa-chat-alpha-sense - Chat name', color: 'good', message: 'Automated Tests Run - Check Build Artifcats for Evidence', teamDomain: 'alpha-sense', token: 'TokenPasteHere'
          }
       	 
       	 }
       	 
       	
    }
    

  }



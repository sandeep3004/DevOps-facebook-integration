#!groovy
stage('VCS') {
    // some block
node {
   echo 'Checkout from Version Control System'
   
}
}

stage('Build'){
node {
    echo "Build project"
}
node {
    echo "Upload artifact to Nexus"
}    
}

stage('Deploy'){
node {
    echo "Deploy artifacts"
}
}

stage('Testing'){
node {
    echo "Perform Testing"
}
}


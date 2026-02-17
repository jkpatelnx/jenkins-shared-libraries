def call(){
    sh "trivy fs . -o result.json"
    echo "Trivy File System Scan Output Saved in results.json"
}

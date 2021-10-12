def call(Map stageParams = [awsRegion: "us-east-1"]){
  withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        cfnCreateChangeSet(
          stack:'EC2Jenkins-Miko', 
          changeSet:'my-change-set', 
          url:'https://testbucket-miko.s3.amazonaws.com/deploy.yml'
        )
        cfnExecuteChangeSet(
          stack:'EC2Jenkins-Miko', 
          changeSet:'my-change-set'
        )
  }
}

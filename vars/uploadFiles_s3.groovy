def call(Map stageParams = [awsRegion: "us-east-1", s3Bucket: "testbucket-miko", s3Path: "/"]) {
    withAWS(region: stageParams.awsRegion, credentials:"${AWS_CRED}") {
        awsIdentity()
        s3Upload( 
            includePathPattern: "**/*",
            bucket: stageParams.s3Bucket
        )
    }
}

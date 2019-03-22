def success() {
    currentBuild.result = "SUCCESS"
}

def handleError(err) {
    echo "Caught: ${err}"
    currentBuild.result = "FAILURE"
    throw any //rethrow exception to prevent the build from proceeding
}

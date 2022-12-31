provider "aws" {
  region = "us-east-1"
}

resource "aws_lambda_function" "lambda_function" {
  function_name = "spring-boot-lambda"
  runtime = "java8"
  handler = "com.example.demo.DemoApplication::main"
  source_code_hash = filebase64("target/demo-0.0.1-SNAPSHOT.jar")
}

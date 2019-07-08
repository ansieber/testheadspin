hs device connect ./test.json
cd infomil
mvn clean test -Denv=SUT_REC -DsuiteXmlFile=src/test/resources/testSuite/SuiteTestNgAndroid.xml

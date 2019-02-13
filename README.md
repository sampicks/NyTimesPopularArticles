# NYTimesPopularArticles

NYTimesPopularArticles is an android application that provides most popular articles from New York Times to a single page.

  - Provides abstract news
  - Provides detailed news
  - Always provide latest news as per their availability on NYTimes

# New Features!

  - Keep updates to user through latest news.


Java programming language is used to develop this application, Java can be downloaded from [https://www.java.com/en/download/]

> The idea is that news should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

### Tech

Following technolotg is used :

* [Java] - Very popular programming language
* [XML] - Another popular language to design layouts
* [Gradle] - Gradle based enviroment

### Design Approach

MVP is used to design this application.

### Library Used
RxJava, RxAndroid:
```sh
implementation 'io.reactivex.rxjava2:rxandroid:2.0.1'
implementation 'io.reactivex.rxjava2:rxjava:2.1.10'
```
Gson:
```sh
implementation 'com.google.code.gson:gson:2.8.2'
```
Retrofit:
```sh
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:adapter-rxjava:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation 'com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0'
```
#### Project level Build.gradle
```sh
classpath 'com.android.tools.build:gradle:3.2.1'
```
#### Unit Test
under test
```sh
  @Test
    @Ignore
    public void clickButton() {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        assertNotNull("Toolbar could not be found", toolbar);
        assertNotNull("content framelayout not found", activity.findViewById(R.id.container));
    }
```
#### Unit Test (Android)
under androidTest
```sh
 @Test
    public void testToolbar() {
        Activity activity = activityTestRule.getActivity();
        Toolbar toolbarView = activity.findViewById(R.id.toolbar);
        assertTrue(toolbarView.isShown());
        assertEquals(InstrumentationRegistry.getTargetContext().getString(R.string.popular_articles), toolbarView.getTitle());
    }
```

### Code Quality Check
SonarQube is used to check code quality. Here are implementation steps.
Add following in project level Build.gradle
```sh
 classpath "org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.6.1"
```
Add following in app level Build.gradle file
```sh
apply plugin: "org.sonarqube"

sonarqube {
    properties {
        property "sonar.projectName", "NYTimesPopularArticles"
        property "sonar.projectKey", "com.nytimes.populararticles"
        property "sonar.host.url", "http://192.114.1.1:9000"
        property "sonar.language", "java"
        property "sonar.sources", "src/main/"
        property "sonar.login", "<username>"
        property "sonar.password", "<password>"
    }
}
```
Now move to gradle.properties
```sh
 systemProp.sonar.host.url=http://localhost:9000
 
 systemProp.sonar.login=<username>
systemProp.sonar.password=<password>
```
Test result file is located under project with name "SonarQube_TestResult_Screen.png"

### Development
Want to contribute? Most Welcome!

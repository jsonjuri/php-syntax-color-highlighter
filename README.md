# PHP Syntax Color Plugin

## Table Of Contents
* [Language Additions](#language-additions)
* [Development](#development)

## Language Additions

This plugin adds more Color Scheme settings for Php allowing a finer customization of the language's keywords.

<figure>
<figcaption>Color Scheme Settings</figcaption>
<img src="/docs/settings.png" alt="Color Scheme Settings">
</figure>

## Development

### Requirements

* JDK 1.8
* IntelliJ IDEA with Gradle

### Developing using IntelliJ Gradle

You can simplify development process thanks to Intellij's **Gradle plugin**. Install the plugin, restart the IDE and you will be prompted with a window asking if you want to import the project as a Gradle project. After that IntelliJ will download the Gradle Wrapper and the tasks will appear in the Gradle Tool Panel on the right.

Import the project from the `build.gradle` file and develop as normal.  Make sure you select JDK 8 in the import wizard.  The other defaults are fine.  You can run the above mentioned CLI Gradle tasks directly in the Gradle Tool Window, which expands from the right side of the screen.  To debug, find "`runIde`" in the list, right-click it, and choose Run/Debug.

### Testing the plugin

Once you've done developing, you can test the plugin on a real IDE instead of the sandbox. To do so, first select the `buildPlugin` task in the Gradle Tool Window. If everything went fine, it would create a new build of the plugin named `<PluginName>-<version>.jar` inside the `build/distributions` folder.

Then open the plugins page (Settings > Plugin) and select `Install plugin from disk`, then select the jar file and restart the IDE. If all worked well you should see your additions in the Color Scheme Settings.

### Adding new keywords

If you want to add new keywords to the provided languages, here's a quick tutorial:

Let's say for instance that I want to highlight differently the "class" keyword in Java:
1. Open the file `PhpAnnotator.java`.
2. Create a new `TextAttributesKey` at the top named `CLASS` (or whatever you want) and assign it a new TextAttributes with a key of your choice, for instance `JAVA.MYCUSTOM_CLASS`.
3. Note that in order to not override existing TextAttributeKeys provided by the IDE, it is recommended to add a custom identifier that will most likely not be used by the IDE or other plugins. The recommended denomination would be `<language>.<identifier>_<keyword>`
4. Select the fallback attributes key, e.g. the color to take if the user didn't select a color. Here it would be the `PHP_KEYWORD` key.
5. Implement the `getKeywordKind` method. This method will parse the editor text and annotate the keywords with the relevant TextAttributesKey. Here it would return the `CLASS` key if it finds the text "class".

We're done with the annotator. Here we already have all occurrences of the "class" word annotated with our brand new TextAttributesKey and we can already change their color by modifying the color scheme's `.icls` file. But of course it would be easier to have it in the Color Scheme Settings. Here's how:

1. Open the file `PhpColorSettings.java`
2. Add a new `TextAttributesKey` like before, but instead of _creating_ a new one, we will reuse the one created in the `PhpAnnotator`.
3. Add a new `AttributesDescriptor` in the `PHP_ATTRIBUTES` field. This will be the new entry in the Java Color Scheme page.
4. Optional: Add a new "tag" in the `createAdditionalHlAttrs` method and assign it the `TextAttributesKey`. Here it would be `custom_class` for instance.
5. Optional: Change the `demoText` and add an example text of your custom keyword, wrapped by the new "tag" you created previously. Here, it would be something like `public <custom_class>class</custom_class> <class>Foo</class>`

That's it! Now in the __Php Colors__ page you will see your new entry, with the fallback you chose, and optionally the code representing the addition with preview in realtime. Once you click "OK" your PHP code will be annotated with your new colors!

PS: Be aware that even though your annotators are bundled with your plugin, the languages they extend are plugin-dependant, meaning that your KotlinAnnotator will only work if the Kotlin plugin is installed in your users IDEs.

--------------------


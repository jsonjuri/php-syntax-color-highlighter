package com.jsonjuri.settings;

import com.intellij.icons.AllIcons;
import com.intellij.lang.Language;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.psi.codeStyle.DisplayPriority;
import com.intellij.util.ObjectUtils;
import com.intellij.util.PlatformUtils;
import com.jsonjuri.annotators.PHPAnnotator;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

import javax.swing.Icon;

import gnu.trove.THashMap;

public class PHPColorSettings extends BaseColorSettings {
  @NonNls
  static final AttributesDescriptor[] PHP_ATTRIBUTES;
  @NonNls
  static final Map<String, TextAttributesKey> PHP_DESCRIPTORS = new THashMap<>();

  private static final TextAttributesKey PHPKEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"),
          DefaultLanguageHighlighterColors.KEYWORD);
  private static final TextAttributesKey VARIABLE = ObjectUtils.notNull(TextAttributesKey.find("PHP_VAR"),
          DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
  private static final TextAttributesKey CLASS = ObjectUtils.notNull(TextAttributesKey.find("PHP_CLASS"),
          DefaultLanguageHighlighterColors.CLASS_NAME);
  private static final TextAttributesKey NUMBER = ObjectUtils.notNull(TextAttributesKey.find("PHP_NUMBER"),
          DefaultLanguageHighlighterColors.NUMBER);
  private static final TextAttributesKey CONSTANT = ObjectUtils.notNull(TextAttributesKey.find("PHP_CONSTANT"),
          DefaultLanguageHighlighterColors.CONSTANT);
  private static final TextAttributesKey FN = ObjectUtils.notNull(TextAttributesKey.find("PHP_FUNCTION_CALL"),
          DefaultLanguageHighlighterColors.FUNCTION_CALL);

  private static final TextAttributesKey FUNCTION = PHPAnnotator.FUNCTION;
  private static final TextAttributesKey THIS_SELF = PHPAnnotator.THIS_SELF;
  private static final TextAttributesKey MODIFIER = PHPAnnotator.MODIFIER;
  private static final TextAttributesKey STATIC_FINAL = PHPAnnotator.STATIC_FINAL;
  private static final TextAttributesKey USE_NAMESPACE = PHPAnnotator.USE_NAMESPACE;

  private static final TextAttributesKey PHP_HANDLING_FUNCTION = PHPAnnotator.PHP_HANDLING_FUNCTION;
  private static final TextAttributesKey PHP_STRING_FUNCTION = PHPAnnotator.PHP_STRING_FUNCTION;
  private static final TextAttributesKey PHP_ARRAY_FUNCTION = PHPAnnotator.PHP_ARRAY_FUNCTION;
  private static final TextAttributesKey PHP_OBJECT_FUNCTION = PHPAnnotator.PHP_OBJECT_FUNCTION;
  private static final TextAttributesKey PHP_MISC_FUNCTION = PHPAnnotator.PHP_MISC_FUNCTION;
  private static final TextAttributesKey PHP_JSON_FUNCTION = PHPAnnotator.PHP_JSON_FUNCTION;
  private static final TextAttributesKey PHP_MATH_FUNCTION = PHPAnnotator.PHP_MATH_FUNCTION;
  private static final TextAttributesKey PHP_HANDLER_FUNCTION = PHPAnnotator.PHP_HANDLER_FUNCTION;
  private static final TextAttributesKey PHP_SUCCESS = PHPAnnotator.PHP_SUCCESS;
  private static final TextAttributesKey PHP_ERROR = PHPAnnotator.PHP_ERROR;

  static {
    PHP_ATTRIBUTES = new AttributesDescriptor[]{
        new AttributesDescriptor("Keywords: function", PHPColorSettings.FUNCTION),
        new AttributesDescriptor("Keywords: self", PHPColorSettings.THIS_SELF),
        new AttributesDescriptor("Keywords: private, public, protected", PHPColorSettings.MODIFIER),
        new AttributesDescriptor("Keywords: static, final", PHPColorSettings.STATIC_FINAL),
        new AttributesDescriptor("Keywords: use, namespace", PHPColorSettings.USE_NAMESPACE),
        new AttributesDescriptor("Keywords: isset, empty, is_numeric, is_​array", PHPColorSettings.PHP_HANDLING_FUNCTION),
        new AttributesDescriptor("Keywords: echo, explode, ucfirst, htmlentities", PHPColorSettings.PHP_STRING_FUNCTION),
        new AttributesDescriptor("Keywords: array, array_walk, array_key_exists, array_merge", PHPColorSettings.PHP_ARRAY_FUNCTION),
        new AttributesDescriptor("Keywords: get_class, is_a, call_user_method, class_exists", PHPColorSettings.PHP_OBJECT_FUNCTION),
        new AttributesDescriptor("Keywords: define, exit, die, sleep, eval", PHPColorSettings.PHP_MISC_FUNCTION),
        new AttributesDescriptor("Keywords: json_encode, json_decode, json_last_error, son_last_error_msg", PHPColorSettings.PHP_JSON_FUNCTION),
        new AttributesDescriptor("Keywords: abs, ceil, round, max", PHPColorSettings.PHP_MATH_FUNCTION),
        new AttributesDescriptor("Keywords: call_user_func_array, function_exists, func_num_args, register_tick_function", PHPColorSettings.PHP_HANDLER_FUNCTION),
        new AttributesDescriptor("Keywords: onSuccess, success, allow, true", PHPColorSettings.PHP_SUCCESS),
        new AttributesDescriptor("Keywords: onError, error, critical, deny, false", PHPColorSettings.PHP_ERROR),
    };

    PHPColorSettings.PHP_DESCRIPTORS.putAll(PHPColorSettings.createAdditionalHlAttrs());
  }

  private static Map<String, TextAttributesKey> createAdditionalHlAttrs() {
    final Map<String, TextAttributesKey> descriptors = new THashMap<>();
    descriptors.put("keyword", PHPColorSettings.PHPKEYWORD);
    descriptors.put("function", PHPColorSettings.FUNCTION);
    descriptors.put("class", PHPColorSettings.CLASS);
    descriptors.put("const", PHPColorSettings.CONSTANT);
    descriptors.put("num", PHPColorSettings.NUMBER);
    descriptors.put("var", PHPColorSettings.VARIABLE);
    descriptors.put("fn", PHPColorSettings.FN);

    descriptors.put("use", PHPColorSettings.USE_NAMESPACE);
    descriptors.put("static", PHPColorSettings.STATIC_FINAL);
    descriptors.put("modifier", PHPColorSettings.MODIFIER);
    descriptors.put("self", PHPColorSettings.THIS_SELF);

    descriptors.put("php_function", PHPColorSettings.PHP_HANDLING_FUNCTION);
    descriptors.put("string_function", PHPColorSettings.PHP_STRING_FUNCTION);
    descriptors.put("array_function", PHPColorSettings.PHP_ARRAY_FUNCTION);
    descriptors.put("object_function", PHPColorSettings.PHP_OBJECT_FUNCTION);
    descriptors.put("misc_function", PHPColorSettings.PHP_MISC_FUNCTION);
    descriptors.put("json_function", PHPColorSettings.PHP_JSON_FUNCTION);
    descriptors.put("math_function", PHPColorSettings.PHP_MATH_FUNCTION);
    descriptors.put("handler_function", PHPColorSettings.PHP_HANDLER_FUNCTION);
    descriptors.put("php_success", PHPColorSettings.PHP_SUCCESS);
    descriptors.put("php_error", PHPColorSettings.PHP_ERROR);

    return descriptors;
  }

  @Nullable
  @Override
  public Icon getIcon() {
    return AllIcons.FileTypes.JavaScript;
  }

  @NotNull
  @Override
  public SyntaxHighlighter getHighlighter() {
    final Language lang = ObjectUtils.notNull(Language.findLanguageByID("PHP"), Language.ANY);
    return getSyntaxHighlighterWithFallback(lang);
  }

  @NotNull
  @Override
  public String getDemoText() {
    return "<use>namespace</use> Foo\\Bar\\Baz;\n" +
            "\n" +
            "<use>use</use> <class>SomeClass</class>" +
            "\n" +
            "<static>final</static> <keyword>class</keyword> <class>MyClass</class> <keyword>extends</keyword> " +
            "<class>MyOtherClass</class> {\n" +
            "    <modifier>public</modifier> <keyword>const</keyword> <var>SINGLE</var> = <num>1</num>;\n" +
            "    <modifier>private</modifier> <var>$variable</var>;\n" +
            "    <modifier>protected</modifier> <var>$arguments</var>;\n" +
            "}\n" +
            "\n" +
            "<modifier>public</modifier> <function>function</function> <fn>byeWorld</fn>() {\n" +
            "    <keyword>return</keyword> <self>self</self>::<var>variable</var>;\n" +
            "}\n" +
            "\n" +
            "<modifier>public</modifier> <function>function</function> <fn>helloWorld</fn>() {\n" +
            "    <keyword>if</keyword> (<php_function>isset</php_function>(<var>$variable</var>)) {\n" +
            "        <var>$title</var> = <string_function>ucfirst</string_function>(<var>$variable</var>);\n" +
            "        <keyword>if</keyword> (<object_function>class_exists</object_function>(<keyword>test_class</keyword>) && <handler_function>function_exists</handler_function>(<keyword>test_function</keyword>)) {\n" +
            "            <var>$numargs</var> = <handler_function>func_num_args</handler_function>();\n" +
            "            <var>$array</var> = <array_function>array_merge</array_function>(<var>$array1</var>, <var>$array2</var>);\n" +
            "            <var>$total</var> = <math_function>ceil</math_function>(<var>$numargs</var>);\n" +
            "            <var>$this</var>-><php_success>success</php_success>();\n" +
            "            <misc_function>exit</misc_function>(<json_function>json_encode</json_function>(<var>$array</var>));\n" +
            "        }\n" +
            "    } else {\n" +
            "        <keyword>return</keyword> <var>$this</var>-><php_error>error</php_error>();\n" +
            "    }\n" +
            "}";
  }

  @Nullable
  @Override
  public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
    return PHP_DESCRIPTORS;
  }

  @NotNull
  @Override
  public AttributesDescriptor[] getAttributeDescriptors() {
    return PHP_ATTRIBUTES;
  }

  @NotNull
  @Override
  public ColorDescriptor[] getColorDescriptors() {
    return ColorDescriptor.EMPTY_ARRAY;
  }

  @NotNull
  @Override
  public String getDisplayName() {
    return "PHP Colors";
  }

  @Override
  public DisplayPriority getPriority() {
    return PlatformUtils.isWebStorm() ? DisplayPriority.KEY_LANGUAGE_SETTINGS : DisplayPriority.LANGUAGE_SETTINGS;
  }
}

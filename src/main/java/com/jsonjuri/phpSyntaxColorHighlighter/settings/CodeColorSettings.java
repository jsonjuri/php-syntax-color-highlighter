/*
 * The MIT License (MIT)
 *
 * Copyright (c) Elior "Mallowigi" Boukhobza & jsonjuri
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 *
 */

package com.jsonjuri.phpSyntaxColorHighlighter.settings;

import com.jsonjuri.phpSyntaxColorHighlighter.CodeColorAnnotator;
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
import gnu.trove.THashMap;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.Map;

@SuppressWarnings({"DuplicateStringLiteralInspection", "ClassWithTooManyFields"})

public final class CodeColorSettings extends BaseColorSettings {
    @NonNls
    static final AttributesDescriptor[] PHP_ATTRIBUTES;
    @NonNls
    static final Map<String, TextAttributesKey> PHP_DESCRIPTORS = new THashMap<>();

    private static final TextAttributesKey DEFAULT_DOC_COMMENT = ObjectUtils.notNull(TextAttributesKey.find("DOC_COMMENT"),
            DefaultLanguageHighlighterColors.DOC_COMMENT);
    private static final TextAttributesKey DEFAULT_PHP_KEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"),
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

    private static final TextAttributesKey FUNCTION = CodeColorAnnotator.FUNCTION;
    private static final TextAttributesKey PHP_RETURN = CodeColorAnnotator.PHP_RETURN;
    private static final TextAttributesKey THIS_SELF = CodeColorAnnotator.THIS_SELF;
    private static final TextAttributesKey MODIFIER = CodeColorAnnotator.MODIFIER;
    private static final TextAttributesKey STATIC_FINAL = CodeColorAnnotator.STATIC_FINAL;
    private static final TextAttributesKey USE_NAMESPACE = CodeColorAnnotator.USE_NAMESPACE;

    private static final TextAttributesKey PHP_HANDLING_FUNCTION = CodeColorAnnotator.PHP_HANDLING_FUNCTION;
    private static final TextAttributesKey PHP_STRING_FUNCTION = CodeColorAnnotator.PHP_STRING_FUNCTION;
    private static final TextAttributesKey PHP_ARRAY_FUNCTION = CodeColorAnnotator.PHP_ARRAY_FUNCTION;
    private static final TextAttributesKey PHP_OBJECT_FUNCTION = CodeColorAnnotator.PHP_OBJECT_FUNCTION;
    private static final TextAttributesKey PHP_MISC_FUNCTION = CodeColorAnnotator.PHP_MISC_FUNCTION;
    private static final TextAttributesKey PHP_JSON_FUNCTION = CodeColorAnnotator.PHP_JSON_FUNCTION;
    private static final TextAttributesKey PHP_MATH_FUNCTION = CodeColorAnnotator.PHP_MATH_FUNCTION;
    private static final TextAttributesKey PHP_HANDLER_FUNCTION = CodeColorAnnotator.PHP_HANDLER_FUNCTION;
    private static final TextAttributesKey PHP_TRUE_KEYWORD = CodeColorAnnotator.PHP_TRUE_KEYWORD;
    private static final TextAttributesKey PHP_FALSE_KEYWORD = CodeColorAnnotator.PHP_FALSE_KEYWORD;
    private static final TextAttributesKey PHP_NULL_KEYWORD = CodeColorAnnotator.PHP_NULL_KEYWORD;
    private static final TextAttributesKey PHP_PREG = CodeColorAnnotator.PHP_PREG;
    private static final TextAttributesKey PHP_DATE = CodeColorAnnotator.PHP_DATE;
    private static final TextAttributesKey PHP_DEBUG = CodeColorAnnotator.PHP_DEBUG;
    private static final TextAttributesKey PHP_SUCCESS = CodeColorAnnotator.PHP_SUCCESS;
    private static final TextAttributesKey PHP_ERROR = CodeColorAnnotator.PHP_ERROR;
    private static final TextAttributesKey PHPDOC_INTERNAL = CodeColorAnnotator.PHPDOC_INTERNAL;

    //private static final TextAttributesKey PHP_RETURN_TYPE = CodeColorAnnotator.PHP_RETURN_TYPE;

    static {
        PHP_ATTRIBUTES = new AttributesDescriptor[]{
                new AttributesDescriptor("function", FUNCTION),
                new AttributesDescriptor("return", PHP_RETURN),
                new AttributesDescriptor("self", THIS_SELF),
                new AttributesDescriptor("private, public, protected", MODIFIER),
                new AttributesDescriptor("static, final", STATIC_FINAL),
                new AttributesDescriptor("use, namespace", USE_NAMESPACE),
                new AttributesDescriptor("isset, empty, is_numeric, is_array, is_callable, is_object, is_countable, is_string, is_int, is_bool", PHP_HANDLING_FUNCTION),
                new AttributesDescriptor("echo, explode, ucfirst, htmlentities", PHP_STRING_FUNCTION),
                new AttributesDescriptor("array, array_walk, array_key_exists, array_merge", PHP_ARRAY_FUNCTION),
                new AttributesDescriptor("get_class, is_a, call_user_method, class_exists", PHP_OBJECT_FUNCTION),
                new AttributesDescriptor("define, exit, die, sleep, eval", PHP_MISC_FUNCTION),
                new AttributesDescriptor("json_encode, json_decode", PHP_JSON_FUNCTION),
                new AttributesDescriptor("abs, ceil, round, max", PHP_MATH_FUNCTION),
                new AttributesDescriptor("call_user_func_array, function_exists, func_num_args, register_tick_function", PHP_HANDLER_FUNCTION),
                new AttributesDescriptor("true", PHP_TRUE_KEYWORD),
                new AttributesDescriptor("false", PHP_FALSE_KEYWORD),
                new AttributesDescriptor("null", PHP_NULL_KEYWORD),
                new AttributesDescriptor("preg_filter, preg_grep, preg_last_error_msg, preg_match_all, preg_match, preg_quote, preg_replace_callback_array, preg_replace_callback, preg_replace, preg_split", PHP_PREG),
                new AttributesDescriptor("date, gmdate, idate, mktime, time, getdate, getlastmod, IntlDateFormatter, DateTimeImmutable, DateTime", PHP_DATE),
                new AttributesDescriptor("print_r, console, debug, var_dump, var_export", PHP_DEBUG),
                new AttributesDescriptor("onSuccess, success, allow, true", PHP_SUCCESS),
                new AttributesDescriptor("onError, error, critical, deny, false, json_last_error, json_last_error_msg", PHP_ERROR)
                //new AttributesDescriptor(": int, : float, : bool, : string, : interfaces, : array, : object, : callable", PHP_RETURN_TYPE),
        };

        PHP_DESCRIPTORS.putAll(createAdditionalHlAttrs());
    }

    private static Map<String, TextAttributesKey> createAdditionalHlAttrs() {
        final Map<String, TextAttributesKey> descriptors = new THashMap<>();
        descriptors.put("keyword", DEFAULT_PHP_KEYWORD);
        descriptors.put("function", FUNCTION);
        descriptors.put("php_return", PHP_RETURN);
        descriptors.put("class", CLASS);
        descriptors.put("const", CONSTANT);
        descriptors.put("num", NUMBER);
        descriptors.put("var", VARIABLE);
        descriptors.put("fn", FN);

        descriptors.put("use", USE_NAMESPACE);
        descriptors.put("static", STATIC_FINAL);
        descriptors.put("modifier", MODIFIER);
        descriptors.put("self", THIS_SELF);

        descriptors.put("php_function", PHP_HANDLING_FUNCTION);
        descriptors.put("string_function", PHP_STRING_FUNCTION);
        descriptors.put("array_function", PHP_ARRAY_FUNCTION);
        descriptors.put("object_function", PHP_OBJECT_FUNCTION);
        descriptors.put("misc_function", PHP_MISC_FUNCTION);
        descriptors.put("json_function", PHP_JSON_FUNCTION);
        descriptors.put("math_function", PHP_MATH_FUNCTION);
        descriptors.put("handler_function", PHP_HANDLER_FUNCTION);
        descriptors.put("php_true_keyword", PHP_TRUE_KEYWORD);
        descriptors.put("php_false_keyword", PHP_FALSE_KEYWORD);
        descriptors.put("php_null_keyword", PHP_NULL_KEYWORD);
        descriptors.put("php_debug", PHP_DEBUG);
        descriptors.put("php_preg_match", PHP_PREG);
        descriptors.put("php_date", PHP_DATE);
        descriptors.put("php_success", PHP_SUCCESS);
        descriptors.put("php_error", PHP_ERROR);
        //descriptors.put("php_return_type", PHP_RETURN_TYPE);

        return descriptors;
    }

    @Override
    public @NotNull Icon getIcon() {
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
                "    <php_return>return</php_return> <self>self</self>::<var>variable</var>;\n" +
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
                "            <var>$date</var> = <php_date>date</php_date>('l jS \\of F Y h:i:s A', <var>$var</var>);\n" +
                "            <php_debug>print_r</php_debug>(<var>$date</var>);\n" +
                "            <var>$good</var> = <php_true_keyword>true</php_true_keyword>;\n" +
                "            <var>$bad</var> = <php_false_keyword>false</php_false_keyword>;\n" +
                "            <var>$empty</var> = <php_null_keyword>null</php_null_keyword>;\n" +
                "            <var>$match</var> = <php_preg_match>preg_match</php_preg_match>(\"/[0-9]+/\", \"Hello, 123 World!\", <var>$matches</var>);\n" +
                "            <misc_function>exit</misc_function>(<json_function>json_encode</json_function>(<var>$array</var>));\n" +
                "        }\n" +
                "    } else {\n" +
                "        <php_return>return</php_return> <var>$this</var>-><php_error>error</php_error>();\n" +
                "    }\n" +
                "}";
    }

    @Override
    public @NotNull Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return PHP_DESCRIPTORS;
    }

    @NotNull
    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return PHP_ATTRIBUTES;
    }

    @NotNull
    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
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

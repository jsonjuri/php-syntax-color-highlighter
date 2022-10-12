/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015-2021 Elior "Mallowigi" Boukhobza
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

    private static final TextAttributesKey FUNCTION = CodeColorAnnotator.FUNCTION;
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
    private static final TextAttributesKey PHP_SUCCESS = CodeColorAnnotator.PHP_SUCCESS;
    private static final TextAttributesKey PHP_ERROR = CodeColorAnnotator.PHP_ERROR;

    static {
        PHP_ATTRIBUTES = new AttributesDescriptor[]{
                new AttributesDescriptor("Keywords: function", FUNCTION),
                new AttributesDescriptor("Keywords: self", THIS_SELF),
                new AttributesDescriptor("Keywords: private, public, protected", MODIFIER),
                new AttributesDescriptor("Keywords: static, final", STATIC_FINAL),
                new AttributesDescriptor("Keywords: use, namespace", USE_NAMESPACE),
                new AttributesDescriptor("Keywords: isset, empty, is_numeric, is_array", PHP_HANDLING_FUNCTION),
                new AttributesDescriptor("Keywords: echo, explode, ucfirst, htmlentities", PHP_STRING_FUNCTION),
                new AttributesDescriptor("Keywords: array, array_walk, array_key_exists, array_merge", PHP_ARRAY_FUNCTION),
                new AttributesDescriptor("Keywords: get_class, is_a, call_user_method, class_exists", PHP_OBJECT_FUNCTION),
                new AttributesDescriptor("Keywords: define, exit, die, sleep, eval", PHP_MISC_FUNCTION),
                new AttributesDescriptor("Keywords: json_encode, json_decode, json_last_error, son_last_error_msg", PHP_JSON_FUNCTION),
                new AttributesDescriptor("Keywords: abs, ceil, round, max", PHP_MATH_FUNCTION),
                new AttributesDescriptor("Keywords: call_user_func_array, function_exists, func_num_args, register_tick_function", PHP_HANDLER_FUNCTION),
                new AttributesDescriptor("Keywords: onSuccess, success, allow, true", PHP_SUCCESS),
                new AttributesDescriptor("Keywords: onError, error, critical, deny, false", PHP_ERROR),
        };

        PHP_DESCRIPTORS.putAll(createAdditionalHlAttrs());
    }

    private static Map<String, TextAttributesKey> createAdditionalHlAttrs() {
        final Map<String, TextAttributesKey> descriptors = new THashMap<>();
        descriptors.put("keyword", PHPKEYWORD);
        descriptors.put("function", FUNCTION);
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
        descriptors.put("php_success", PHP_SUCCESS);
        descriptors.put("php_error", PHP_ERROR);

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

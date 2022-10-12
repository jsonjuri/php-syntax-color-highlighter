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

package com.jsonjuri.phpSyntaxColorHighlighter;

import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ObjectUtils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings({"DuplicateStringLiteralInspection",
        "SwitchStatement",
        "HardCodedStringLiteral",
        "SwitchStatementWithTooManyBranches",
        "OverlyLongMethod"})
public final class CodeColorAnnotator implements Annotator {
    @SuppressWarnings("MethodWithMultipleReturnPoints")
    public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {
        if (element instanceof LeafPsiElement) {
            if (PsiTreeUtil.getParentOfType(element, PsiComment.class) != null) {
                return;
            }

            final TextAttributesKey kind = getKeywordKind(element);
            if (kind == null) {
                return;
            }
            final TextRange textRange = element.getTextRange();
            final TextRange range = new TextRange(textRange.getStartOffset(), textRange.getEndOffset());
            holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(range)
                    .textAttributes(kind)
                    .create();
        }
    }

    public static final TextAttributesKey PHP_KEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"), DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey MODIFIER = TextAttributesKey.createTextAttributesKey("PHP.MODIFIER", PHP_KEYWORD);
    public static final TextAttributesKey STATIC_FINAL = TextAttributesKey.createTextAttributesKey("PHP.STATIC_FINAL", PHP_KEYWORD);
    public static final TextAttributesKey THIS_SELF = TextAttributesKey.createTextAttributesKey("PHP.THIS_SELF", PHP_KEYWORD);
    public static final TextAttributesKey USE_NAMESPACE = TextAttributesKey.createTextAttributesKey("PHP.USE_NAMESPACE", PHP_KEYWORD);
    public static final TextAttributesKey FUNCTION = TextAttributesKey.createTextAttributesKey("PHP.FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_HANDLING_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_HANDLING_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_STRING_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_STRING_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_ARRAY_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_ARRAY_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_OBJECT_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_OBJECT_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_MISC_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_MISC_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_JSON_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_JSON_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_MATH_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_MATH_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_HANDLER_FUNCTION = TextAttributesKey.createTextAttributesKey("PHP_HANDLER_FUNCTION", PHP_KEYWORD);
    public static final TextAttributesKey PHP_SUCCESS = TextAttributesKey.createTextAttributesKey("PHP_SUCCESS", PHP_KEYWORD);
    public static final TextAttributesKey PHP_ERROR = TextAttributesKey.createTextAttributesKey("PHP_ERROR", PHP_KEYWORD);

    @Nullable
    private TextAttributesKey getKeywordKind(@NotNull final PsiElement element) {
        TextAttributesKey kind = null;
        switch (element.getText()) {
            case "private":
            case "public":
            case "protected":
                kind = MODIFIER;
                break;

            case "static":
            case "final":
                kind = STATIC_FINAL;
                break;

            case "self":
                kind = THIS_SELF;
                break;

            case "use":
            case "namespace":
                kind = USE_NAMESPACE;
                break;

            case "function":
                kind = FUNCTION;
                break;

            case "boolval":
            case "debug_zval_dump":
            case "doubleval":
            case "empty":
            case "floatval":
            case "get_defined_vars":
            case "get_resource_type":
            case "gettype":
            case "intval":
            case "is_array":
            case "is_bool":
            case "is_callable":
            case "is_countable":
            case "is_double":
            case "is_float":
            case "is_int":
            case "is_integer":
            case "is_iterable":
            case "is_long":
            case "is_numeric":
            case "is_object":
            case "is_real":
            case "is_resource":
            case "is_scalar":
            case "is_string":
            case "isset":
            case "print_r":
            case "serialize":
            case "settype":
            case "strval":
            case "unserialize":
            case "unset":
            case "var_dump":
            case "var_export":
            case "this":
            case "super":
                kind = PHP_HANDLING_FUNCTION;
                break;

            case "addcslashes":
            case "addslashes":
            case "bin2hex":
            case "chop":
            case "chr":
            case "chunk_split":
            case "convert_cyr_string":
            case "convert_uudecode":
            case "convert_uuencode":
            case "count_chars":
            case "crc32":
            case "crypt":
            case "echo":
            case "explode":
            case "fprintf":
            case "get_html_translation_table":
            case "hebrev":
            case "hebrevc":
            case "hex2bin":
            case "html_entity_decode":
            case "htmlentities":
            case "htmlspecialchars_decode":
            case "htmlspecialchars":
            case "implode":
            case "join":
            case "lcfirst":
            case "levenshtein":
            case "localeconv":
            case "ltrim":
            case "md5_file":
            case "md5":
            case "metaphone":
            case "money_format":
            case "nl_langinfo":
            case "nl2br":
            case "number_format":
            case "ord":
            case "parse_str":
            case "print":
            case "printf":
            case "quoted_printable_decode":
            case "quoted_printable_encode":
            case "quotemeta":
            case "rtrim":
            case "setlocale":
            case "sha1_file":
            case "sha1":
            case "similar_text":
            case "soundex":
            case "sprintf":
            case "sscanf":
            case "str_getcsv":
            case "str_ireplace":
            case "str_pad":
            case "str_repeat":
            case "str_replace":
            case "str_rot13":
            case "str_shuffle":
            case "str_split":
            case "str_word_count":
            case "strcasecmp":
            case "strchr":
            case "strcmp":
            case "strcoll":
            case "strcspn":
            case "strip_tags":
            case "stripcslashes":
            case "stripos":
            case "stripslashes":
            case "stristr":
            case "strlen":
            case "strnatcasecmp":
            case "strnatcmp":
            case "strncasecmp":
            case "strncmp":
            case "strpbrk":
            case "strpos":
            case "strrchr":
            case "strrev":
            case "strripos":
            case "strrpos":
            case "strspn":
            case "strstr":
            case "strtok":
            case "strtolower":
            case "strtoupper":
            case "strtr":
            case "substr_compare":
            case "substr_count":
            case "substr_replace":
            case "substr":
            case "trim":
            case "ucfirst":
            case "ucwords":
            case "vfprintf":
            case "vprintf":
            case "vsprintf":
            case "wordwrap":
                kind = PHP_STRING_FUNCTION;
                break;

            case "array_change_key_case":
            case "array_chunk":
            case "array_column":
            case "array_combine":
            case "array_count_values":
            case "array_diff_assoc":
            case "array_diff_key":
            case "array_diff_uassoc":
            case "array_diff_ukey":
            case "array_diff":
            case "array_fill_keys":
            case "array_fill":
            case "array_filter":
            case "array_flip":
            case "array_intersect_assoc":
            case "array_intersect_key":
            case "array_intersect_uassoc":
            case "array_intersect_ukey":
            case "array_intersect":
            case "array_key_exists":
            case "array_key_first":
            case "array_key_last":
            case "array_keys":
            case "array_map":
            case "array_merge_recursive":
            case "array_merge":
            case "array_multisort":
            case "array_pad":
            case "array_pop":
            case "array_product":
            case "array_push":
            case "array_rand":
            case "array_reduce":
            case "array_replace_recursive":
            case "array_replace":
            case "array_reverse":
            case "array_search":
            case "array_shift":
            case "array_slice":
            case "array_splice":
            case "array_sum":
            case "array_udiff_assoc":
            case "array_udiff_uassoc":
            case "array_udiff":
            case "array_uintersect_assoc":
            case "array_uintersect_uassoc":
            case "array_uintersect":
            case "array_unique":
            case "array_unshift":
            case "array_values":
            case "array_walk_recursive":
            case "array_walk":
            case "array":
            case "arsort":
            case "asort":
            case "compact":
            case "count":
            case "current":
            case "end":
            case "extract":
            case "in_array":
            case "key_exists":
            case "key":
            case "krsort":
            case "ksort":
            case "list":
            case "natcasesort":
            case "natsort":
            case "next":
            case "pos":
            case "prev":
            case "range":
            case "reset":
            case "rsort":
            case "shuffle":
            case "sizeof":
            case "sort":
            case "uasort":
            case "uksort":
            case "usort":
            case "each":
                kind = PHP_ARRAY_FUNCTION;
                break;

            case "__autoload":
            case "class_alias":
            case "class_exists":
            case "get_called_class":
            case "get_class_methods":
            case "get_class_vars":
            case "get_class":
            case "get_declared_classes":
            case "get_declared_interfaces":
            case "get_declared_traits":
            case "get_object_vars":
            case "get_parent_class":
            case "interface_exists":
            case "is_a":
            case "is_subclass_of":
            case "method_exists":
            case "property_exists":
            case "trait_exists":
                kind = PHP_OBJECT_FUNCTION;
                break;

            case "connection_aborted":
            case "connection_status":
            case "constant":
            case "define":
            case "defined":
            case "die":
            case "eval":
            case "exit":
            case "get_browser":
            case "__halt_compiler":
            case "highlight_file":
            case "highlight_string":
            case "hrtime":
            case "ignore_user_abort":
            case "pack":
            case "php_check_syntax":
            case "php_strip_whitespace":
            case "sapi_windows_cp_conv":
            case "sapi_windows_cp_get":
            case "sapi_windows_cp_is_utf8":
            case "sapi_windows_cp_set":
            case "sapi_windows_generate_ctrl_event":
            case "sapi_windows_set_ctrl_handler":
            case "sapi_windows_vt100_support":
            case "show_source":
            case "sleep":
            case "sys_getloadavg":
            case "time_nanosleep":
            case "time_sleep_until":
            case "uniqid":
            case "unpack":
            case "usleep":
                kind = PHP_MISC_FUNCTION;
                break;

            case "json_decode":
            case "json_encode":
            case "json_last_error_msg":
            case "json_last_error":
                kind = PHP_JSON_FUNCTION;
                break;

            case "abs":
            case "acos":
            case "acosh":
            case "asin":
            case "asinh":
            case "atan2":
            case "atan":
            case "atanh":
            case "base_convert":
            case "bindec":
            case "ceil":
            case "cos":
            case "cosh":
            case "decbin":
            case "dechex":
            case "decoct":
            case "deg2rad":
            case "exp":
            case "expm1":
            case "floor":
            case "fmod":
            case "getrandmax":
            case "hexdec":
            case "hypot":
            case "intdiv":
            case "is_finite":
            case "is_infinite":
            case "is_nan":
            case "lcg_value":
            case "log10":
            case "log1p":
            case "log":
            case "max":
            case "min":
            case "mt_getrandmax":
            case "mt_rand":
            case "mt_srand":
            case "octdec":
            case "pi":
            case "pow":
            case "rad2deg":
            case "rand":
            case "round":
            case "sin":
            case "sinh":
            case "sqrt":
            case "srand":
            case "tan":
            case "tanh":
                kind = PHP_MATH_FUNCTION;
                break;

            case "call_user_func_array":
            case "call_user_func":
            case "forward_static_call_array":
            case "forward_static_call":
            case "func_get_arg":
            case "func_get_args":
            case "func_num_args":
            case "function_exists":
            case "get_defined_functions":
            case "register_shutdown_function":
            case "register_tick_function":
            case "unregister_tick_function":
                kind = PHP_HANDLER_FUNCTION;
                break;

            case "success":
            case "onSuccess":
            case "allow":
            case "true":
                kind = PHP_SUCCESS;
                break;

            case "error":
            case "onError":
            case "critical":
            case "deny":
            case "false":
            case "null":
                kind = PHP_ERROR;
                break;
        }
        return kind;
    }
}

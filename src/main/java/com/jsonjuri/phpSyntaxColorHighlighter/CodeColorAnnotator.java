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
    public static final TextAttributesKey PHP_RETURN = TextAttributesKey.createTextAttributesKey("PHP_RETURN", PHP_KEYWORD);
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
    public static final TextAttributesKey PHP_TRUE_KEYWORD = TextAttributesKey.createTextAttributesKey("PHP_TRUE_KEYWORD", PHP_KEYWORD);
    public static final TextAttributesKey PHP_FALSE_KEYWORD = TextAttributesKey.createTextAttributesKey("PHP_FALSE_KEYWORD", PHP_KEYWORD);
    public static final TextAttributesKey PHP_NULL_KEYWORD = TextAttributesKey.createTextAttributesKey("PHP_NULL_KEYWORD", PHP_KEYWORD);
    public static final TextAttributesKey PHP_PREG = TextAttributesKey.createTextAttributesKey("PHP_PREG", PHP_KEYWORD);
    public static final TextAttributesKey PHP_DATE = TextAttributesKey.createTextAttributesKey("PHP_DATE", PHP_KEYWORD);
    public static final TextAttributesKey PHP_DEBUG = TextAttributesKey.createTextAttributesKey("PHP_DEBUG", PHP_KEYWORD);
    public static final TextAttributesKey PHP_SUCCESS = TextAttributesKey.createTextAttributesKey("PHP_SUCCESS", PHP_KEYWORD);
    public static final TextAttributesKey PHP_ERROR = TextAttributesKey.createTextAttributesKey("PHP_ERROR", PHP_KEYWORD);

    public static final TextAttributesKey PHPDOC_INTERNAL = TextAttributesKey.createTextAttributesKey("PHPDOC_INTERNAL", DefaultLanguageHighlighterColors.DOC_COMMENT_TAG);
    //public static final TextAttributesKey PHP_RETURN_TYPE = ObjectUtils.notNull(TextAttributesKey.find("PHP_RETURN_TYPE"), DefaultLanguageHighlighterColors.KEYWORD);

    @Nullable
    private TextAttributesKey getKeywordKind(@NotNull final PsiElement element) {
        TextAttributesKey kind = null;
        String content = element.getText();

        switch (content) {
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

            case "return":
                kind = PHP_RETURN;
                break;

            case "boolval":
            case "debug_zval_dump":
            case "doubleval":
            case "empty":
            case "floatval":
            case "fdiv":
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
            case "is_null":
            case "not_null":
            case "not_string":
            case "not_set":
            case "equals":
            case "not_equals":
            case "greater":
            case "smaller":
            case "equals_or_greater":
            case "equals_or_smaller":
            case "isset":
            case "serialize":
            case "unserialize":
            case "settype":
            case "strval":
            case "unset":
            case "super":
                kind = PHP_HANDLING_FUNCTION;
                break;

            case "true":
                kind = PHP_TRUE_KEYWORD;
                break;

            case "false":
                kind = PHP_FALSE_KEYWORD;
                break;

            case "null":
                kind = PHP_NULL_KEYWORD;
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
            case "str_contains":
            case "str_starts_with":
            case "str_ends_with":
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
            case "grapheme_substr":
            case "iconv_substr":
            case "mb_substr":
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
            case "token_get_all":
            case "function_exists":
            case "get_defined_functions":
            case "get_resource_id":
            case "get_debug_type":
            case "register_shutdown_function":
            case "register_tick_function":
            case "unregister_tick_function":
                kind = PHP_HANDLER_FUNCTION;
                break;

            case "preg_filter":
            case "preg_grep":
            case "preg_match_all":
            case "preg_match":
            case "preg_quote":
            case "preg_replace_callback_array":
            case "preg_replace_callback":
            case "preg_replace":
            case "preg_split":
                kind = PHP_PREG;
                break;

            case "date_default_timezone_set":
            case "date_interval_create_from_date_string":
            case "timezone_version_get":
            case "timezone_abbreviations_list":
            case "timezone_identifiers_list":
            case "timezone_location_get":
            case "timezone_transitions_get":
            case "timezone_offset_get":
            case "timezone_name_from_abbr":
            case "timezone_name_get":
            case "timezone_open":
            case "date_timestamp_get":
            case "date_timestamp_set":
            case "date_isodate_set":
            case "date_date_set":
            case "date_time_set":
            case "date_diff":
            case "date_offset_get":
            case "date_timezone_set":
            case "date_timezone_get":
            case "date_add":
            case "date_sub":
            case "date_modify":
            case "date_format":
            case "date_parse_from_format":
            case "date_create_from_format":
            case "date_create_immutable_from_format":
            case "date_create_immutable":
            case "date_create":
            case "date":
            case "date_sunset":
            case "date_sunrise":
            case "date_sun_info":
            case "gmdate":
            case "idate":
            case "mktime":
            case "strtotime":
            case "time":
            case "getdate":
            case "strftime":
            case "gmmktime":
            case "gmstrftime":
            case "getlastmod":
            case "IntlDateFormatter":
            case "DateTimeImmutable":
            case "DateTime":
                kind = PHP_DATE;
                break;

            case "success":
            case "onSuccess":
            case "allow":
                kind = PHP_SUCCESS;
                break;

            case "error":
            case "onError":
            case "critical":
            case "deny":
            case "intl_get_error_message":
            case "preg_last_error_msg":
            case "preg_last_error":
            case "json_last_error_msg":
            case "json_last_error":
            case "error_get_last":
            case "display_errors":
                kind = PHP_ERROR;
                break;

            case "print_r":
            case "console":
            case "var_dump":
            case "var_export":
            case "debug":
                kind = PHP_DEBUG;
                break;

            /*
            case ": int":
            case ": float":
            case ": bool":
            case ": string":
            case ": array":
            case ": null":
            case ": object":
            case ": interfaces":
            case ": callable":
            case ": mixed":
            case ": never":
            case ": void":
            case ": ?int":
            case ": ?float":
            case ": ?bool":
            case ": ?string":
            case ": ?array":
            case ": ?object":
            case ": ?interfaces":
            case ": ?callable":
            case ": int|float":
            case ": int|bool":
            case ": int|string":
            case ": int|array":
            case ": int|null":
            case ": int|object":
            case ": int|interfaces":
            case ": int|callable":
            case ": float|bool":
            case ": float|string":
            case ": float|array":
            case ": float|null":
            case ": float|object":
            case ": float|interfaces":
            case ": float|callable":
            case ": bool|string":
            case ": bool|array":
            case ": bool|null":
            case ": bool|object":
            case ": bool|interfaces":
            case ": bool|callable":
            case ": string|array":
            case ": string|null":
            case ": string|object":
            case ": string|interfaces":
            case ": string|callable":
            case ": array|null":
            case ": array|object":
            case ": array|interfaces":
            case ": array|callable":
            case ": null|object":
            case ": null|interfaces":
            case ": null|callable":
            case ": object|interfaces":
            case ": object|callable":
            case ": int|float|bool":
            case ": int|float|string":
            case ": int|float|array":
            case ": int|float|null":
            case ": int|float|object":
            case ": int|float|interfaces":
            case ": int|float|callable":
            case ": int|bool|string":
            case ": int|bool|array":
            case ": int|bool|null":
            case ": int|bool|object":
            case ": int|bool|interfaces":
            case ": int|bool|callable":
            case ": int|string|array":
            case ": int|string|null":
            case ": int|string|object":
            case ": int|string|interfaces":
            case ": int|string|callable":
            case ": int|array|null":
            case ": int|array|object":
            case ": int|array|interfaces":
            case ": int|array|callable":
            case ": int|null|object":
            case ": int|null|interfaces":
            case ": int|null|callable":
            case ": int|object|interfaces":
            case ": int|object|callable":
            case ": float|bool|string":
            case ": float|bool|array":
            case ": float|bool|null":
            case ": float|bool|object":
            case ": float|bool|interfaces":
            case ": float|bool|callable":
            case ": float|string|array":
            case ": float|string|null":
            case ": float|string|object":
            case ": float|string|interfaces":
            case ": float|string|callable":
            case ": float|array|null":
            case ": float|array|object":
            case ": float|array|interfaces":
            case ": float|array|callable":
            case ": float|null|object":
            case ": float|null|interfaces":
            case ": float|null|callable":
            case ": float|object|interfaces":
            case ": float|object|callable":
            case ": bool|string|array":
            case ": bool|string|null":
            case ": bool|string|object":
            case ": bool|string|interfaces":
            case ": bool|string|callable":
            case ": bool|array|null":
            case ": bool|array|object":
            case ": bool|array|interfaces":
            case ": bool|array|callable":
            case ": bool|null|object":
            case ": bool|null|interfaces":
            case ": bool|null|callable":
            case ": bool|object|interfaces":
            case ": bool|object|callable":
            case ": string|array|null":
            case ": string|array|object":
            case ": string|array|interfaces":
            case ": string|array|callable":
            case ": string|null|object":
            case ": string|null|interfaces":
            case ": string|null|callable":
            case ": string|object|interfaces":
            case ": string|object|callable":
            case ": array|null|object":
            case ": array|null|interfaces":
            case ": array|null|callable":
            case ": array|object|interfaces":
            case ": array|object|callable":
            case ": null|object|interfaces":
            case ": null|object|callable":
            case ": object|interfaces|callable":
            case ": int|float|bool|string":
            case ": int|float|bool|array":
            case ": int|float|bool|null":
            case ": int|float|bool|object":
            case ": int|float|bool|interfaces":
            case ": int|float|bool|callable":
            case ": int|float|string|array":
            case ": int|float|string|null":
            case ": int|float|string|object":
            case ": int|float|string|interfaces":
            case ": int|float|string|callable":
            case ": int|float|array|null":
            case ": int|float|array|object":
            case ": int|float|array|interfaces":
            case ": int|float|array|callable":
            case ": int|float|null|object":
            case ": int|float|null|interfaces":
            case ": int|float|null|callable":
            case ": int|float|object|interfaces":
            case ": int|float|object|callable":
            case ": int|bool|string|array":
            case ": int|bool|string|null":
            case ": int|bool|string|object":
            case ": int|bool|string|interfaces":
            case ": int|bool|string|callable":
            case ": int|bool|array|null":
            case ": int|bool|array|object":
            case ": int|bool|array|interfaces":
            case ": int|bool|array|callable":
            case ": int|bool|null|object":
            case ": int|bool|null|interfaces":
            case ": int|bool|null|callable":
            case ": int|bool|object|interfaces":
            case ": int|bool|object|callable":
            case ": int|string|array|null":
            case ": int|string|array|object":
            case ": int|string|array|interfaces":
            case ": int|string|array|callable":
            case ": int|string|null|object":
            case ": int|string|null|interfaces":
            case ": int|string|null|callable":
            case ": int|string|object|interfaces":
            case ": int|string|object|callable":
            case ": int|array|null|object":
            case ": int|array|null|interfaces":
            case ": int|array|null|callable":
            case ": int|array|object|interfaces":
            case ": int|array|object|callable":
            case ": int|null|object|interfaces":
            case ": int|null|object|callable":
            case ": float|bool|string|array":
            case ": float|bool|string|null":
            case ": float|bool|string|object":
            case ": float|bool|string|interfaces":
            case ": float|bool|string|callable":
            case ": float|bool|array|null":
            case ": float|bool|array|object":
            case ": float|bool|array|interfaces":
            case ": float|bool|array|callable":
            case ": float|bool|null|object":
            case ": float|bool|null|interfaces":
            case ": float|bool|null|callable":
            case ": float|bool|object|interfaces":
            case ": float|bool|object|callable":
            case ": float|string|array|null":
            case ": float|string|array|object":
            case ": float|string|array|interfaces":
            case ": float|string|array|callable":
            case ": float|string|null|object":
            case ": float|string|null|interfaces":
            case ": float|string|null|callable":
            case ": float|string|object|interfaces":
            case ": float|string|object|callable":
            case ": float|array|null|object":
            case ": float|array|null|interfaces":
            case ": float|array|null|callable":
            case ": float|array|object|interfaces":
            case ": float|array|object|callable":
            case ": float|null|object|interfaces":
            case ": float|null|object|callable":
            case ": bool|string|array|null":
            case ": bool|string|array|object":
            case ": bool|string|array|interfaces":
            case ": bool|string|array|callable":
            case ": bool|string|null|object":
            case ": bool|string|null|interfaces":
            case ": bool|string|null|callable":
            case ": bool|string|object|interfaces":
            case ": bool|string|object|callable":
            case ": bool|array|null|object":
            case ": bool|array|null|interfaces":
            case ": bool|array|null|callable":
            case ": bool|array|object|interfaces":
            case ": bool|array|object|callable":
            case ": bool|null|object|interfaces":
            case ": bool|null|object|callable":
            case ": string|array|null|object":
            case ": string|array|null|interfaces":
            case ": string|array|null|callable":
            case ": string|array|object|interfaces":
            case ": string|array|object|callable":
            case ": string|null|object|interfaces":
            case ": string|null|object|callable":
            case ": array|null|object|interfaces":
            case ": array|null|object|callable":
            case ": null|object|interfaces|callable":
            case ": int|float|bool|string|array":
            case ": int|float|bool|string|null":
            case ": int|float|bool|string|object":
            case ": int|float|bool|string|interfaces":
            case ": int|float|bool|string|callable":
            case ": int|float|bool|array|null":
            case ": int|float|bool|array|object":
            case ": int|float|bool|array|interfaces":
            case ": int|float|bool|array|callable":
            case ": int|float|bool|null|object":
            case ": int|float|bool|null|interfaces":
            case ": int|float|bool|null|callable":
            case ": int|float|bool|object|interfaces":
            case ": int|float|bool|object|callable":
            case ": int|float|string|array|null":
            case ": int|float|string|array|object":
            case ": int|float|string|array|interfaces":
            case ": int|float|array|object|interfaces":
            case ": int|float|array|object|callable":
                kind = PHP_RETURN_TYPE;
                break;
            */
        }

        return kind;
    }
}

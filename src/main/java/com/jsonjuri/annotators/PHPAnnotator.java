package com.jsonjuri.annotators;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.psi.PsiElement;
import com.intellij.util.ObjectUtils;

import org.jetbrains.annotations.NotNull;

public class PHPAnnotator extends BaseAnnotator {

    private static final TextAttributesKey PHP_KEYWORD = ObjectUtils.notNull(TextAttributesKey.find("PHP_KEYWORD"), DefaultLanguageHighlighterColors.KEYWORD);
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

    @Override
    protected TextAttributesKey getKeywordKind(@NotNull final PsiElement element) {
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
            case "debug_​zval_​dump":
            case "doubleval":
            case "empty":
            case "floatval":
            case "get_​defined_​vars":
            case "get_​resource_​type":
            case "gettype":
            case "intval":
            case "is_​array":
            case "is_​bool":
            case "is_​callable":
            case "is_​countable":
            case "is_​double":
            case "is_​float":
            case "is_​int":
            case "is_​integer":
            case "is_​iterable":
            case "is_​long":
            case "is_​numeric":
            case "is_​object":
            case "is_​real":
            case "is_​resource":
            case "is_​scalar":
            case "is_​string":
            case "isset":
            case "print_​r":
            case "serialize":
            case "settype":
            case "strval":
            case "unserialize":
            case "unset":
            case "var_​dump":
            case "var_​export":
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

            case "array_​change_​key_​case":
            case "array_​chunk":
            case "array_​column":
            case "array_​combine":
            case "array_​count_​values":
            case "array_​diff_​assoc":
            case "array_​diff_​key":
            case "array_​diff_​uassoc":
            case "array_​diff_​ukey":
            case "array_​diff":
            case "array_​fill_​keys":
            case "array_​fill":
            case "array_​filter":
            case "array_​flip":
            case "array_​intersect_​assoc":
            case "array_​intersect_​key":
            case "array_​intersect_​uassoc":
            case "array_​intersect_​ukey":
            case "array_​intersect":
            case "array_​key_​exists":
            case "array_​key_​first":
            case "array_​key_​last":
            case "array_​keys":
            case "array_​map":
            case "array_​merge_​recursive":
            case "array_​merge":
            case "array_​multisort":
            case "array_​pad":
            case "array_​pop":
            case "array_​product":
            case "array_​push":
            case "array_​rand":
            case "array_​reduce":
            case "array_​replace_​recursive":
            case "array_​replace":
            case "array_​reverse":
            case "array_​search":
            case "array_​shift":
            case "array_​slice":
            case "array_​splice":
            case "array_​sum":
            case "array_​udiff_​assoc":
            case "array_​udiff_​uassoc":
            case "array_​udiff":
            case "array_​uintersect_​assoc":
            case "array_​uintersect_​uassoc":
            case "array_​uintersect":
            case "array_​unique":
            case "array_​unshift":
            case "array_​values":
            case "array_​walk_​recursive":
            case "array_​walk":
            case "array":
            case "arsort":
            case "asort":
            case "compact":
            case "count":
            case "current":
            case "end":
            case "extract":
            case "in_​array":
            case "key_​exists":
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

            case "_​_​autoload":
            case "class_​alias":
            case "class_​exists":
            case "get_​called_​class":
            case "get_​class_​methods":
            case "get_​class_​vars":
            case "get_​class":
            case "get_​declared_​classes":
            case "get_​declared_​interfaces":
            case "get_​declared_​traits":
            case "get_​object_​vars":
            case "get_​parent_​class":
            case "interface_​exists":
            case "is_​a":
            case "is_​subclass_​of":
            case "method_​exists":
            case "property_​exists":
            case "trait_​exists":
                kind = PHP_OBJECT_FUNCTION;
                break;

            case "connection_​aborted":
            case "connection_​status":
            case "constant":
            case "define":
            case "defined":
            case "die":
            case "eval":
            case "exit":
            case "get_​browser":
            case "_​_​halt_​compiler":
            case "highlight_​file":
            case "highlight_​string":
            case "hrtime":
            case "ignore_​user_​abort":
            case "pack":
            case "php_​check_​syntax":
            case "php_​strip_​whitespace":
            case "sapi_​windows_​cp_​conv":
            case "sapi_​windows_​cp_​get":
            case "sapi_​windows_​cp_​is_​utf8":
            case "sapi_​windows_​cp_​set":
            case "sapi_​windows_​generate_​ctrl_​event":
            case "sapi_​windows_​set_​ctrl_​handler":
            case "sapi_​windows_​vt100_​support":
            case "show_​source":
            case "sleep":
            case "sys_​getloadavg":
            case "time_​nanosleep":
            case "time_​sleep_​until":
            case "uniqid":
            case "unpack":
            case "usleep":
                kind = PHP_MISC_FUNCTION;
                break;

            case "json_​decode":
            case "json_​encode":
            case "json_​last_​error_​msg":
            case "json_​last_​error":
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
            case "base_​convert":
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
            case "is_​finite":
            case "is_​infinite":
            case "is_​nan":
            case "lcg_​value":
            case "log10":
            case "log1p":
            case "log":
            case "max":
            case "min":
            case "mt_​getrandmax":
            case "mt_​rand":
            case "mt_​srand":
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

            case "call_​user_​func_​array":
            case "call_​user_​func":
            case "forward_​static_​call_​array":
            case "forward_​static_​call":
            case "func_​get_​arg":
            case "func_​get_​args":
            case "func_​num_​args":
            case "function_​exists":
            case "get_​defined_​functions":
            case "register_​shutdown_​function":
            case "register_​tick_​function":
            case "unregister_​tick_​function":
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

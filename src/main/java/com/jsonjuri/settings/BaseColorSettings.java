package com.jsonjuri.settings;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.fileTypes.SyntaxHighlighterFactory;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import com.intellij.psi.codeStyle.DisplayPrioritySortable;

abstract class BaseColorSettings implements ColorSettingsPage, DisplayPrioritySortable {
  static SyntaxHighlighter getSyntaxHighlighterWithFallback(final Language lang) {
    final SyntaxHighlighter syntaxHighlighter = SyntaxHighlighterFactory.getSyntaxHighlighter(lang, null, null);
    if (syntaxHighlighter == null) {
      return SyntaxHighlighterFactory.getSyntaxHighlighter(Language.ANY, null, null);
    }
    return syntaxHighlighter;
  }
}

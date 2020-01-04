package com.jsonjuri.annotators;

import com.intellij.lang.annotation.Annotation;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;

public abstract class BaseAnnotator implements Annotator {
  @Override
  public void annotate(@NotNull final PsiElement element, @NotNull final AnnotationHolder holder) {

    if (element instanceof LeafPsiElement) {
      final TextAttributesKey kind = getKeywordKind(element);
      if (kind == null) {
        return;
      }
      final TextRange textRange = element.getTextRange();
      final TextRange range = new TextRange(textRange.getStartOffset(), textRange.getEndOffset());
      final Annotation annotation = holder.createAnnotation(HighlightSeverity.INFORMATION, range, null);

      annotation.setTextAttributes(kind);
    }
  }


  protected abstract TextAttributesKey getKeywordKind(@NotNull PsiElement element);
}

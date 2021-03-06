package de.unidue.ltl.pos.trainmodel.feature;

import java.util.HashSet;
import java.util.Set;

import org.apache.uima.jcas.JCas;
import org.dkpro.tc.api.exception.TextClassificationException;
import org.dkpro.tc.api.features.ClassificationUnitFeatureExtractor;
import org.dkpro.tc.api.features.Feature;
import org.dkpro.tc.api.features.FeatureExtractorResource_ImplBase;
import org.dkpro.tc.api.type.TextClassificationUnit;

public class IsDot extends FeatureExtractorResource_ImplBase implements
		ClassificationUnitFeatureExtractor {

	private final String FEATURE_NAME = "isDot";

	public Set<Feature> extract(JCas aView,
			TextClassificationUnit aClassificationUnit)
			throws TextClassificationException {

		boolean dot = isDot(aClassificationUnit.getCoveredText());
		Feature feature = new Feature(FEATURE_NAME, dot ? 1 : 0);

		Set<Feature> features = new HashSet<Feature>();
		features.add(feature);
		return features;
	}

	static boolean isDot(String aToken) {
		return aToken.equals(".");
	}

}

from nltk import *
answer_key="Machine Learning is the field of study that gives computers the capability to learn without being explicitly programmed"
sent="Machine learning is an application of artificial intelligence (AI) that provides systems the ability to automatically learn and improve from experience without being explicitly programmed. Machine learning focuses on the development of computer programs that can access data and use it learn for themselves"
ans_text = nltk.word_tokenize(answer_key)
sent_text = nltk.word_tokenize(sent)

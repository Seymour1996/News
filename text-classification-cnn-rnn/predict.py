# coding: utf-8

from __future__ import print_function

import os
import tensorflow as tf
import tensorflow.contrib.keras as kr

from cnn_model import TCNNConfig, TextCNN
from data.cnews_loader import read_category, read_vocab

try:
    bool(type(unicode))
except NameError:
    unicode = str

base_dir = 'data/cnews'
vocab_dir = os.path.join(base_dir, 'cnews.vocab.txt')

save_dir = 'checkpoints/textcnn'
save_path = os.path.join(save_dir, 'best_validation')  # 最佳验证结果保存路径


class CnnModel:
    def __init__(self):
        self.config = TCNNConfig()
        self.categories, self.cat_to_id = read_category()
        self.words, self.word_to_id = read_vocab(vocab_dir)
        self.config.vocab_size = len(self.words)
        self.model = TextCNN(self.config)

        self.session = tf.Session()
        self.session.run(tf.global_variables_initializer())
        saver = tf.train.Saver()
        saver.restore(sess=self.session, save_path=save_path)  # 读取保存的模型

    def predict(self, message):
        # 支持不论在python2还是python3下训练的模型都可以在2或者3的环境下运行
        content = unicode(message)
        data = [self.word_to_id[x] for x in content if x in self.word_to_id]

        feed_dict = {
            self.model.input_x: kr.preprocessing.sequence.pad_sequences([data], self.config.seq_length),
            self.model.keep_prob: 1.0
        }

        y_pred_cls = self.session.run(self.model.y_pred_cls, feed_dict=feed_dict)
        return self.categories[y_pred_cls[0]]


if __name__ == '__main__':
    cnn_model = CnnModel()
    test_demo = ['投资并购：“不差钱”玩家优选　　对行业巨头而言，资本出海是通过产品精耕细作以外，快速布局海外市场的一个好选择。以国内游戏界的龙头企业腾讯为例，Sensor Tower所发布的2017中国手游厂商海外收入TOP10榜单中，没有出现腾讯或任何一款腾讯嫡系产品，但事实上腾讯稳稳占据了国内游戏厂商海外收入的榜首。这是因为腾迅的海外收入很大部分来自于其众多独立运行的海外子公司。以2016年被收购的Supercell为例，作为目前全球范围内最具创造力的手游公司，Supercell旗下《皇室战争》、《部落冲突》两款手游2017年全年收入均达到12亿美元，仅次于《王者荣耀》在内的三款产品，分别位列全球手游收入排行榜第四、第五名，为腾讯的海外收入贡献了极大的助力。']
    for i in test_demo:
        print(cnn_model.predict(i))
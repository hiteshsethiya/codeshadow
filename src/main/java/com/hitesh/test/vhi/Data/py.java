/*
import os
import pandas as pd
        from alexa_hoverboard_analytics_py.utils.file_utils
import generate_output_directory, generate_file_name, write_to_file

        #specify s3 config
        # read data from S3 - mashov
        # read data from bluetrain datasets post db_lib_timestamp date
        # for each custId in s3, go through rows in heatmap csv for matched custId
        # if custId matches, then create a new row in a new csv with custId


        def generate_mashov_report_per_customer_id(customer_id):
        # file name to store aggregate data
        file_name = generate_file_name(date)
        for mashov_filename in os.listdir(file_dir):
        df = pd.read_csv(file_dir + filename)
        mashov_data = get_mashov_report_data().map(lambda x: (x.get_customer_id(), x))
        heatmap_data = get_heatmap_report_data().map(lambda x: (x.get_customer_id(), x)) # could have multiple rows with same cust id
        mashov_data.join(heatmap_data)
        for folder in os.listdir(file_dir):
        start_date = filename.split('_')[2]
        if filename.startswith('USAmazon_'):
        df = pd.read_csv(file_dir + filename)
        if(mashov_file_row.customer_id == heatmap_file_row.customer_id):
        add_to_csv(mashov_file_row, heatmap_file_row)
        list.add(customer_id) # to maintain that customer_id is already encountered

        output_dir = generate_output_directory("path-to-dir")
        path = os.path.join(output_dir, file_name)
        write_to_file(path, lines, [
        'utteranceID',
        'customer_id',
        'best sub-unit',
        'domain',
        'locale',
        'intent',
        'creation_date',
        'words',
        'travelogue_0',
        'travelogue_1',
        'visitedFSTs_1',
        'updated_query',
        'dp_lib_timestamp'
        ])


        def transform(data):
        customer_id = data[0]
        mashov_data = data[1][0]
        heatmap_data = data[1][1]
        a = (
        heatmap_data.utterance_id,
        customer_id,
        heatmap_data.best_decoder_subunit,
        heatmap_data.domain,
        heatmap_data.domain,
        heatmap_data.namespace,
        heatmap_data.intent,
        heatmap_data.creation_date,
        heatmap_data.words,
        heatmap_data.travelogue_0,
        heatmap_data.travelogue_1,
        heatmap_data.visitedFSTs_1,
        mashov_data.updated_query,
        mashov_data.dp_lib_timestamp
        )
        return a*/

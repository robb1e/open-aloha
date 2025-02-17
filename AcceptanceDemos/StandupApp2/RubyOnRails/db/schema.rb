# This file is autogenerated. Instead of editing this file, please use the
# migrations feature of ActiveRecord to incrementally modify your database, and
# then regenerate this schema definition.

ActiveRecord::Schema.define(:version => 4) do

  create_table "conferences", :force => true do |t|
    t.column "name", :string
    t.column "time", :time
  end

  create_table "conferences_participants", :id => false, :force => true do |t|
    t.column "conference_id",  :integer
    t.column "participant_id", :integer
  end

  create_table "participants", :force => true do |t|
    t.column "name",  :string
    t.column "telno", :string
  end

end
